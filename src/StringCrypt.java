/*     */ 
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.net.URL;
/*     */ import java.security.Key;
/*     */ import java.security.Provider;
/*     */ import java.security.Security;
/*     */ import java.util.Properties;
import javax.crypto.Cipher;




/*     */ 
/*     */ public class StringCrypt
/*     */ {
/*     */   private Key key;
/*     */   private static String provider;
/*     */   private static String providerName;
/*     */ 
/*     */   public StringCrypt(String keyString)
/*     */   {
/*  47 */     this.key = new K("DES", keyString.getBytes());
/*     */   }
/*     */ 
/*     */   public String encrypt(String s)
/*     */   {
/*  52 */     byte[] b = s.getBytes();
/*  53 */     return SUtils.byteArrayToString(encrypt(b));
/*     */   }
/*     */ 
/*     */   public String decrypt(String s)
/*     */   {
/*  58 */     byte[] encrypted = SUtils.hexFromString(s);
/*  59 */     byte[] plain = decrypt(encrypted);
/*  60 */     return new String(plain);
/*     */   }
/*     */ 
/*     */   public byte[] encrypt(byte[] b)
/*     */   {
/*  65 */     if (b == null)
/*  66 */       return null;
/*     */     try
/*     */     {
/*  69 */       Cipher ph = Cipher.getInstance("DES", providerName);
/*  70 */       ph.init(1, this.key);
/*  71 */       byte[] abyte0 = ph.doFinal(b);
/*  72 */       return abyte0;
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  76 */       e.printStackTrace();
/*  77 */       throw new RuntimeException(e.getMessage());
/*     */     }
/*     */   }
/*     */ 
/*     */   public byte[] decrypt(byte[] b)
/*     */   {
/*  83 */     if (b == null)
/*  84 */       return null;
/*     */     try
/*     */     {
/*  87 */       Cipher ph = Cipher.getInstance("DES", providerName);
/*  88 */       ph.init(2, this.key);
/*  89 */       byte[] abyte0 = ph.doFinal(b);
/*  90 */       return abyte0;
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  94 */       throw new RuntimeException(e.getMessage());
/*     */     }
/*     */   }
/*     */ 
/*     */   static Class _mthclass$(String x$0)
/*     */   {
/*     */     try
/*     */     {
/* 102 */       return Class.forName(x$0);
/*     */     }
/*     */     catch (ClassNotFoundException x)
/*     */     {
/* 106 */       throw new NoClassDefFoundError(x.getMessage());
/*     */     }
/*     */   }
/*     */ 
/*     */   static
/*     */   {
/*     */     try
/*     */     {
/* 118 */       URL url = StringCrypt.class.getResource("StringCipher.properties");
/* 119 */       Properties prop = new Properties();
/* 120 */       prop.load(url.openStream());
/* 121 */       provider = prop.getProperty("jce.provider", "com.isnetworks.provider.jce.ISNetworksProvider").trim();
/* 122 */       providerName = prop.getProperty("jce.provider.name", "ISNetworks").trim();
/*     */     }
/*     */     catch (IOException ioexception) {
/*     */     }
/*     */     try {
/* 127 */       Security.addProvider((Provider)Class.forName(provider).newInstance());
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 131 */       System.err.println("Can not register JCE Provider!");
/* 132 */       ex.printStackTrace(System.err);
/*     */     }
/*     */   }
/*     */ 
/*     */   private class K
/*     */     implements Key
/*     */   {
/*     */     private final byte[] keyBytes;
/*     */     private final String alg;
/*     */ 
/*     */     public String getAlgorithm()
/*     */     {
/*  22 */       return this.alg;
/*     */     }
/*     */ 
/*     */     public String getFormat()
/*     */     {
/*  27 */       return "RAW";
/*     */     }
/*     */ 
/*     */     public byte[] getEncoded()
/*     */     {
/*  32 */       return ((byte[])(byte[])this.keyBytes.clone());
/*     */     }
/*     */ 
/*     */     K(String paramString, byte[] paramArrayOfByte)
/*     */     {
/*  40 */       this.alg = paramString;
/*  41 */       this.keyBytes = paramArrayOfByte;
/*     */     }
/*     */   }
/*     */ }

/* Location:           F:\applications0903\applications\WEB-INF\classes\
 * Qualified Name:     com.aicoa.org.util.StringCrypt
 * JD-Core Version:    0.5.3
 */