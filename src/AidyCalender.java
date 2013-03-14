/**
 * @(#)AidyCalender.java
 *
 *
 * @author 
 * @version 1.00 2008/7/19
 */
import java.awt.*; 
import java.awt.event.*; 
import java.lang.StringBuffer;
import javax.swing.*;
import java.util.*;
import javax.swing.Timer;
import javax.swing.border.*;







public class AidyCalender extends JFrame implements ActionListener,ItemListener{
	Date date = new Date(); 
    private GregorianCalendar gregorianCalendar = new GregorianCalendar();
    //锟斤拷锟斤拷锟斤拷英锟斤拷锟街凤拷锟斤拷锟斤拷娲拷锟斤拷锟斤拷锟较�锟斤拷锟斤拷转锟斤拷锟斤拷示
    private String[] stringWeekEn = new String[] { "SUN", "MON", "TUE", "WED",
			"THU", "FRI", "SAT" };
	private String[] stringWeekCn = new String[] { "锟斤拷锟斤拷锟斤拷", "锟斤拷锟斤拷一", "锟斤拷锟节讹拷", "锟斤拷锟斤拷锟斤拷",
			"锟斤拷锟斤拷锟斤拷", "锟斤拷锟斤拷锟斤拷", "锟斤拷锟斤拷锟斤拷" };
	//锟斤拷锟斤拷娲拷路莸锟斤拷锟较拷锟斤拷锟�锟斤拷锟斤拷转锟斤拷锟斤拷示锟斤拷示
	private String[] stringMonthEn = new String[] { "Jan", "Feb", "Mar", "Apr",
			"May", "Jun", "Jul", "Aug", "Sept", "Oct", "Nov", "Dec" };
	private String[] stringMonthCn = {"一锟斤拷","锟斤拷锟斤拷","锟斤拷锟斤拷","锟斤拷锟斤拷","锟斤拷锟斤拷","锟斤拷锟斤拷",
									"锟斤拷锟斤拷","锟斤拷锟斤拷","锟斤拷锟斤拷","十锟斤拷","十一锟斤拷","十锟斤拷锟斤拷"};

	private String[] sysNowTime = new String[6];//sysNowTime 锟斤拷锟节存储系统时锟斤拷谋锟斤拷锟�
	private String[] sysRunTime = new String[6];	
    private JLabel []labelWeek = new JLabel[7];        
    private JLabel []labelDay = new JLabel[42];
    private JLabel labelTime = new JLabel();
    
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel panel3 = new JPanel();
    private JComboBox combo1 = new JComboBox();
    private JComboBox combo2 = new JComboBox();
    private JButton buttonToday = new JButton();
    
    private Border border 	= BorderFactory.createRaisedBevelBorder();
    private Border border1 = BorderFactory.createLineBorder(Color.cyan,3);

    public AidyCalender(String title) {
    	super(title);
        
        for (int y = 1900; y < 2101; y++) {
			combo1.addItem("  " + new Integer(y).toString()+"锟斤拷"); 
        }
        for (int m = 0;m<12;m++){
        	combo2.addItem("  "+stringMonthCn[m]);
        }
        buttonToday.setText("锟斤拷 锟斤拷");
        setLayout(new FlowLayout());
        add(panel1);
        add(panel2);
        add(panel3);
        panel1.setLayout(new GridLayout(1,3,10,0));
        panel1.add(combo1); 
        combo1.addItemListener(this);      
        panel1.add(combo2);
        combo2.addItemListener(this);
        panel1.add(buttonToday);
        buttonToday.addActionListener(this);
        labelTime.setFont(new Font("锟斤拷锟斤拷",Font.PLAIN,16));
        labelTime.setForeground(Color.MAGENTA);
        panel1.add(labelTime);
        Timer time = new Timer(1000,new TimerListener());
        time.addActionListener(new TimerListener());
        //time.setRepeats(true);        
        time.start();
        
        //labelTime.addAncestorListener(new TimerListener());
         
           
        
        panel2.setLayout(new GridLayout(7,7,0,10));
        panel2.setBackground(Color.white);
        
        for(int i=0;i<7;i++){
        	labelWeek[i] = new JLabel();
        	labelWeek[i].setHorizontalAlignment(0);
        	if(i==0||i==6){
        		labelWeek[i].setBackground(Color.blue);
        		labelWeek[i].setForeground(Color.RED);
        		labelWeek[i].setFont(new Font("锟斤拷锟斤拷",Font.BOLD,14));
        	}
        		
        	else{
        		labelWeek[i].setForeground(Color.BLACK);
        		labelWeek[i].setFont(new Font("锟斤拷锟斤拷锟斤拷",Font.PLAIN,14));
        	}
        		
        	labelWeek[i].setText(stringWeekCn[i]);
        	panel2.add(labelWeek[i]);
        			
        }
        for(int i= 0;i<42;i++){
        	labelDay[i] = new JLabel();
        	labelDay[i].setHorizontalAlignment(0);
        	labelDay[i].setText("");
        	panel2.add(labelDay[i]);
        }

        addWindowListener(new WindowAdapter(){ 
            public void windowClosing(WindowEvent e){ 
                System.exit(0); 
            } 
        }); 
        

        setSize(300,300); 
        setBounds(250, 200, 400, 360);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        getSysDate();
        setNowDate();
    } 
    	
   
    public void actionPerformed(ActionEvent ae){
    	if(ae.getSource()==buttonToday){
    		setNowDate();
    	}
    	
    		
    	}
    public void itemStateChanged(ItemEvent aa){
    	setChangeDate();
    	
    	}
    
    		
    
    
    
    public int turnWeek(String week){
    	int i;
    	for(i=0;i<7;i++)
    		if(week.equalsIgnoreCase(stringWeekEn[i]))
    			break;
		return i;    	
    }
   
    public int turnMonth(String month){
    	 /**
     	 *int turnMonth(String month)
     	 *@month 系统锟斤拷锟斤拷锟叫碉拷锟斤拷,锟斤拷锟斤拷Jan\Feb
     	 *@return int
    	 *锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷值,锟斤拷锟斤拷寻锟斤拷stringMonthCn[]锟斤拷锟斤拷锟叫讹拷应锟斤拷锟斤拷锟斤拷锟铰凤拷
   	     */
    	int i;
    	for(i=0;i<12;i++)
    		if(month.equalsIgnoreCase(stringMonthEn[i]))
    			break;
    	return i;    	
    }
    /**
     *setNowDate()
     *锟斤拷锟矫碉拷前系统锟斤拷锟斤拷
     */
    public void setNowDate(){
    	    	
    	setSysDate(getNowYear(),getNowMonth());
    	getSysRunDate();    	
    	setDateNull();
    	combo1.setSelectedIndex(getShowYear() - 1900);
		combo2.setSelectedIndex(getShowMonth());
		setDays(getMonthDays(getNowYear(),getNowMonth()),getInitWeek(sysRunTime[0]),getNowDay());
		//labelTime.setText(sysNowTime[3]);
		//labelTime.setHorizontalAlignment(0);	
    }

    
    /**Integer getShowYear()
     *锟斤拷取锟斤拷峡锟斤拷锟接︼拷锟斤拷锟绞撅拷锟斤拷锟斤拷
     */
    
    public void setSysDate(int year,int month){
    	gregorianCalendar.set(year,month,1);
    }
    public void setDateNull(){
    	for(int i=0;i<42;i++){
    		labelDay[i].setText("");
    	}
    }
    public void setChangeDate(){
    	setSysDate(getComboYear(),getComboMonth());
    	getSysRunDate();
    	setDateNull();
    	setDays(getMonthDays(getComboYear(),getComboMonth()),getInitWeek(sysRunTime[0]),-1);
    	
    }
	public int getMonthDays(int year, int month) {
		/**
     	 *锟斤拷锟斤拷锟斤拷选锟斤拷锟铰碉拷锟斤拷锟斤拷,锟斤拷为锟斤拷锟斤拷锟叫碉拷锟斤拷值锟斤拷0锟斤拷始,锟斤拷锟斤拷3\5\8\10锟街憋拷锟斤拷4\6\9\11锟斤拷锟斤拷小锟斤拷.
	 	 *锟斤拷1锟斤拷锟�锟斤拷,锟斤拷锟斤拷锟角凤拷为锟斤拷锟斤拷锟叫讹拷,选锟今返伙拷28锟斤拷29锟斤拷.
	 	 *锟斤拷锟斤拷锟铰凤拷为锟斤拷锟斤拷,锟斤拷锟斤拷31锟斤拷.
	 	 **/
		switch (month) {
		case 3:
		case 5:
		case 8:
		case 10:
			return 30;//小锟铰凤拷锟斤拷30锟斤拷
		case 1:
			if (gregorianCalendar.isLeapYear(year)) {
				//isLeapYear(year)确锟斤拷锟斤拷前锟斤拷元锟叫碉拷指锟斤拷锟斤拷锟斤拷欠锟轿拷锟斤拷辍�
				return 29;
			} else {
				return 28;
			}//锟斤拷锟斤拷亩锟斤拷路锟斤拷锟�9锟届，平锟疥返锟斤拷28锟斤拷
		default:
			return 31;
			//锟斤拷锟铰凤拷锟斤拷31锟斤拷
		}
	}
	/**
	 *int getComboYear()
	 *锟斤拷取锟斤拷峡锟斤拷械锟斤拷锟斤拷
	 */
	public void getSysDate(){
		date = gregorianCalendar.getTime();
    	sysNowTime = (date.toString()).split(" ");
	}
	public void getSysRunDate(){
		date = gregorianCalendar.getTime();
		sysRunTime = (date.toString()).split(" ");
	}
	public int getComboYear(){
		return combo1.getSelectedIndex()+1900;
	}
	
	/**
	 *int getComboMonth()
	 *锟斤拷取锟斤拷锟斤拷峡锟斤拷械锟斤拷锟斤拷锟街�
	 */
	public int getComboMonth(){
		return combo2.getSelectedIndex();
	}
	
    public int getInitWeek(String initWeek){
    	/**
	 	 *getWeekNow(String initWeek)
	 	 *@para nowWeek 系统锟斤拷锟斤拷锟叫碉拷锟斤拷锟斤拷
	 	 *锟斤拷锟截碉拷锟斤拷锟叫碉拷1锟斤拷锟角达拷锟斤拷锟节硷拷锟斤拷始
	 	 */
    	int nowWeek = 0 ;
    	for(int i = 0;i<7;i++){
    		if(initWeek.equalsIgnoreCase(stringWeekEn[i])){
    		
    			nowWeek = i;
    			break;
    		}
    	}
    	return nowWeek;
    }
    public int getNowYear(){
    	return Integer.parseInt(sysNowTime[5]);
    }
    public int getNowMonth(){
    	int nowMonth=0;
    	for(int i=0;i<12;i++){
    		if(sysNowTime[1].equalsIgnoreCase(stringMonthEn[i]));
    		nowMonth=i;
    		break;
    	}
    	return nowMonth;    		
    }
    public int getNowDay(){
    	return Integer.parseInt(sysNowTime[2]);
    	
    }
    public Integer getShowYear(){
    	return Integer.parseInt(sysNowTime[5]);    	
    }
    
    public Integer getShowMonth(){
    	/**
     	 *Integer getShowMonth()
     	 *锟斤拷取锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷示锟斤拷锟斤拷锟侥革拷式锟铰凤拷:锟斤拷锟斤拷锟斤拷\锟斤拷锟铰碉拷
     	 */
    	return turnMonth(sysNowTime[1]);
    }
    
     public void setDays(int monthDays,int initWeek,int day){
     	/**
     	 *void setDays(int monthDays,int initWeek,int day)
      	 *@para monthDays  锟斤拷锟斤拷锟斤拷锟斤拷
     	 *@para initWeek 锟斤拷始锟斤拷锟斤拷
     	 *@para day 锟斤拷锟斤拷锟斤拷
     	 *锟斤拷锟斤拷锟斤拷锟斤拷
     	 */
     	setDateNull();
     	for(int i=initWeek;i<initWeek+monthDays+1;i++){
     		if((i-initWeek+1)==day){
     			labelDay[i].setBorder(border1);
     			labelDay[i].setForeground(Color.BLUE);
     			labelDay[i].setFont(new Font("锟斤拷锟斤拷",Font.BOLD,20));
     		}else if((i%7==0)||(i%7==6))
     			labelDay[i].setForeground(Color.RED);
     			else{
     				labelDay[i].setForeground(Color.BLACK);
     			}
     		labelDay[i].setText(String.valueOf(i-initWeek+1));
     	}
     	for(int i=initWeek+monthDays;i<42;i++)
     		labelDay[i].setText("");
     }
        
    
    class TimerListener implements ActionListener{
    	//AdapterDemo var=new AdapterDemo("锟斤拷锟斤拷锟斤拷锟斤拷锟�-Aidy");

    	public void actionPerformed(ActionEvent e) {
    	
    		GregorianCalendar g = new GregorianCalendar();
    		String clock = new String((g.getTime().toString().split(" "))[3]);    	
    		labelTime.setText(clock);
    	}

    }
    public static void main(String args[])
    { 
    	try{
    		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    	}catch(Exception e){
    		throw new RuntimeException(e);
    	}
     	AidyCalender var=new AidyCalender("锟斤拷锟斤拷锟斤拷锟斤拷锟�-Aidy");
     	
      
    }
    
    
}