/*     */ package MainCore;
/*     */ 
/*     */ import java.io.DataInput;
/*     */ import java.io.DataOutput;
/*     */ import java.io.IOException;
/*     */ import java.net.BindException;
/*     */ import java.net.InetAddress;
/*     */ import java.net.ServerSocket;
/*     */ import java.net.UnknownHostException;

/*     */ 

/*     */ public class Uuid
/*     */ {
/*     */   private long high;
/*     */   private long low;
/*     */   private transient String str36;
/*  21 */   private static int UUID_HOST_LOCK_PORT = 5504;
/*     */   private static ServerSocket lockSocket;
/*     */   private static long timeStamp;
/*     */   private static long adapterAddress;
/*     */   private static int instanceCounter;
/*  26 */   private static final char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
/*     */ 
/*     */   public static synchronized Uuid create()
/*     */     throws UuidException
/*     */   {
/*  33 */     if (timeStamp == 0L) {
/*  34 */       setTimeStamp();
/*     */     }
/*  36 */     if (adapterAddress == 0L) {
/*  37 */       setAdapterAddress();
/*     */     }
/*  39 */     Uuid uuid = new Uuid();
/*  40 */     long midTime = timeStamp >> 32 & 0xFFFFFFFF;
/*  41 */     uuid.high = (timeStamp << 32 | midTime << 16 & 0xFFFF0000 | 0x1000 | timeStamp >> 48 & 0xFFF);
/*  42 */     int count = instanceCounter++;
/*  43 */     if (count == 536870911) {
/*  44 */       instanceCounter = 0;
/*  45 */       setTimeStamp();
/*     */     }
/*  47 */     uuid.low = ((count & 0x1FFFFFFF) << 32 | 0x0 | adapterAddress);
/*  48 */     return uuid;
/*     */   }
/*     */ 
/*     */   private Uuid() {
/*  52 */     this.str36 = null;
/*     */   }
/*     */ 
/*     */   private Uuid(long high, long low) {
/*  56 */     this.str36 = null;
/*  57 */     this.high = high;
/*  58 */     this.low = low;
/*     */   }
/*     */ 
/*     */   private static void setAdapterAddress() throws UuidException
/*     */   {
/*     */     try {
/*  64 */       byte[] addr = InetAddress.getLocalHost().getAddress();
/*  65 */       int raw = addr[3] & 0xFF | addr[2] << 8 & 0xFF00 | addr[1] << 16 & 0xFF0000 | addr[0] << 24 & 0xFF000000;
/*  66 */       adapterAddress = raw & 0xFFFFFFFF;
/*     */     } catch (UnknownHostException e) {
/*  68 */       throw new UuidException("Unexpected failure");
/*     */     }
/*     */   }
/*     */ 
/*     */   private static void setTimeStamp() throws UuidException
/*     */   {
/*  74 */     acquireHostLock();
/*     */     try {
/*  76 */       long newTime = System.currentTimeMillis();
/*  77 */       if (timeStamp != 0L) {
/*  78 */         if (newTime < timeStamp) {
/*  79 */           throw new UuidException("Unique identifier clock failure");
/*     */         }
/*  81 */         if (newTime == timeStamp) {
/*  82 */           letClockTick(newTime);
/*  83 */           newTime = System.currentTimeMillis();
/*     */         }
/*     */       }
/*  86 */       timeStamp = newTime;
/*     */     } finally {
/*  88 */       releaseHostLock();
/*     */     }
/*     */   }
/*     */ 
/*     */   private static void letClockTick(long curTime) throws UuidException
/*     */   {
/*  94 */     int timeoutCounter = 0;
/*  95 */     long sleepTime = 1L;
/*  96 */     for (long newTime = System.currentTimeMillis(); newTime == curTime; newTime = System.currentTimeMillis()) {
/*  97 */       ++timeoutCounter;
/*  98 */       sleepTime *= 2L;
/*     */       try {
/* 100 */         Thread.sleep(sleepTime);
/*     */       } catch (InterruptedException interruptedexception) {
/*     */       }
/* 103 */       if (sleepTime > 60000L)
/* 104 */         throw new UuidException("Unique identifier unexpected failure");
/*     */     }
/*     */   }
/*     */ 
/*     */   private static void acquireHostLock()
/*     */     throws UuidException
/*     */   {
/* 112 */     String portProperty = null;
/*     */     try {
/* 114 */       portProperty = System.getProperty("bluewater.uuid.hostLockPort");
/*     */     } catch (SecurityException securityexception) {
/*     */     }
/* 117 */     if (portProperty != null)
/*     */       try {
/* 119 */         UUID_HOST_LOCK_PORT = Integer.parseInt(portProperty);
/*     */       }
/*     */       catch (NumberFormatException numberformatexception) {
/*     */       }
/* 123 */     for (int numberOfRetrys = 0; lockSocket == null; ++numberOfRetrys) {
/*     */       try {
/* 125 */         lockSocket = new ServerSocket(UUID_HOST_LOCK_PORT);
/* 126 */         return;
/*     */       } catch (BindException e) {
/*     */       } catch (IOException e2) {
/* 129 */         throw new UuidException("Unique identifier unexpected failure");
/*     */       }
/*     */       try {
/* 132 */         Thread.sleep(100L);
/*     */       } catch (InterruptedException interruptedexception) {
/*     */       }
/* 135 */       if (numberOfRetrys == 1200)
/* 136 */         throw new UuidException("Unique identifier lock failure");
/*     */     }
/*     */   }
/*     */ 
/*     */   private static void releaseHostLock()
/*     */   {
/* 143 */     if (lockSocket == null) return;
/*     */     try {
/* 145 */       lockSocket.close();
/*     */     } catch (IOException ioexception) {
/*     */     }
/* 148 */     lockSocket = null;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object obj)
/*     */   {
/* 153 */     if ((obj != null) && (obj instanceof Uuid)) {
/* 154 */       return ((this.high == ((Uuid)obj).high) && (this.low == ((Uuid)obj).low));
/*     */     }
/* 156 */     return false;
/*     */   }
/*     */ 
/*     */   public int hashCode()
/*     */   {
/* 161 */     return ((int)(this.low << 24) & 0xFF000000 | (int)(this.high >> 20) & 0xFFF000 | (int)(this.low >> 32) & 0xFFF);
/*     */   }
/*     */ 
/*     */   public String toString() {
/* 165 */     if (this.str36 != null) {
/* 166 */       return this.str36;
/*     */     }
/* 168 */     StringBuffer buf = new StringBuffer();
/* 169 */     buf.append(toHexString(this.high >>> 32, 8)).append("-");
/* 170 */     buf.append(toHexString(this.high >>> 16, 4)).append("-");
/* 171 */     buf.append(toHexString(this.high, 4)).append("-");
/* 172 */     buf.append(toHexString(this.low >>> 48, 4)).append("-");
/* 173 */     buf.append(toHexString(this.low, 12));
/* 174 */     this.str36 = buf.toString();
/* 175 */     return this.str36;
/*     */   }
/*     */ 
/*     */   private static String toHexString(long x, int chars)
/*     */   {
/* 180 */     char[] buf = new char[chars];
/* 181 */     for (int charPos = chars; --charPos >= 0; ) {
/* 182 */       buf[charPos] = hexDigits[(int)(x & 0xF)];
/* 183 */       x >>>= 4;
/*     */     }
/*     */ 
/* 186 */     return new String(buf);
/*     */   }
/*     */ 
/*     */   public byte[] toByteArray() {
/* 190 */     byte[] array = new byte[16];
/* 191 */     toBytes(this.high, array, 0);
/* 192 */     toBytes(this.low, array, 8);
/* 193 */     return array;
/*     */   }
/*     */ 
/*     */   private void toBytes(long x, byte[] array, int startPos) {
/* 197 */     for (int bytePos = 8; --bytePos >= 0; ) {
/* 198 */       array[(startPos + bytePos)] = (byte)(int)(x & 0xFF);
/* 199 */       x >>>= 8;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void write(DataOutput out)
/*     */     throws IOException
/*     */   {
/* 206 */     out.writeLong(this.high);
/* 207 */     out.writeLong(this.low);
/*     */   }
/*     */ 
/*     */   public static Uuid read(DataInput in) throws IOException
/*     */   {
/* 212 */     long high = in.readLong();
/* 213 */     long low = in.readLong();
/* 214 */     return new Uuid(high, low);
/*     */   }
/*     */ 
/*     */   public static Uuid read(String id) throws UuidException
/*     */   {
/*     */     try {
/* 220 */       String part = id.substring(0, 8);
/* 221 */       long high = 0L;
/* 222 */       high = Long.parseLong(part, 16) << 32;
/* 223 */       part = id.substring(9, 13);
/* 224 */       high |= Long.parseLong(part, 16) << 16;
/* 225 */       part = id.substring(14, 18);
/* 226 */       high |= Long.parseLong(part, 16);
/* 227 */       long low = 0L;
/* 228 */       part = id.substring(19, 23);
/* 229 */       low = Long.parseLong(part, 16) << 48;
/* 230 */       part = id.substring(24, 36);
/* 231 */       low |= Long.parseLong(part, 16);
/* 232 */       Uuid uuid = new Uuid(high, low);
/* 233 */       Uuid uuid1 = uuid;
/* 234 */       return uuid1;
/*     */     } catch (Exception ex) {
/* 236 */       throw new UuidException("Invalid uuid String.");
/*     */     }
/*     */   }
/*     */ }

/* Location:           F:\applications0903\applications\WEB-INF\classes\
 * Qualified Name:     net.aicoa.entity.Uuid
 * JD-Core Version:    0.5.3
 */