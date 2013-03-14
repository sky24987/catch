
public class person {
	private static String id;
	private static String leftHand;
	private static String rightHand;
	public static String getId() {
		return id;
	}
	public static void setId(String id) {
		person.id = id;
	}
	public static String getLeftHand() {
		return leftHand;
	}
	public static void setLeftHand(String leftHand) {
		person.leftHand = leftHand;
	}
	public static String getRightHand() {
		return rightHand;
	}
	public static void setRightHand(String rightHand) {
		person.rightHand = rightHand;
	}
	
	public static void main(String a[]){
		System.out.println("hello world");
	}
}
