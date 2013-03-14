/*    */ 
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ 
/*    */ public class PasswordVerify
/*    */ {
/*    */   private static final String PREDEFINED_DES_KEY = "37D06BB516CB7546";
/*    */   private static StringCrypt cipher;
/*    */ 
/*    */   public static boolean verify(String plain, String encoded)
/*    */   {
/*    */     try
/*    */     {
/* 14 */       if (SUtils.isEmpty(plain)) {
/* 15 */         boolean flag = SUtils.isEmpty(encoded);
/* 16 */         return flag;
/*    */       }
/* 18 */       boolean flag1 = encoded.equalsIgnoreCase(EncodePassword(plain));
/* 19 */       return flag1;
/*    */     }
/*    */     catch (Throwable cryptexception) {
/*    */     }
/* 23 */     return false;
/*    */   }
/*    */ 
/*    */   public static String EncodePassword(String plain)
/*    */   {
/* 28 */     return getCipher().encrypt(plain);
/*    */   }
/*    */ 
/*    */   public static String DecodePassword(String encryted) {
/* 32 */     return getCipher().decrypt(encryted);
/*    */   }
/*    */ 
/*    */   private static StringCrypt getCipher() {
/* 36 */     if (cipher == null)
/* 37 */       cipher = new StringCrypt("37D06BB516CB7546");
/* 38 */     return cipher;
/*    */   }
/*    */ 
/*    */   public static void main(String[] args)
/*    */   {
			System.out.println(DecodePassword("C49E697C1D925386"));
    
			 System.out.println(EncodePassword("102471"));
			 System.out.println(EncodePassword("/app/sms/sms_main.jsp|’≈∫≠|123456"));
			 System.out.println(DecodePassword("C49E697C1D925386"));
/*    */   }
/*    */ }

