package ocs.bootstrap;

import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import ocs.db.OCSDb;
import ocs.pojos.Student;

/*
 * Welcome to Operation Company Switch.
 */
public class OCSBootstrapper {
	
	private static OCSBootstrapper INSTANCE = new OCSBootstrapper();
	/**
	 * Configure these parameters depending on your needs.
	 */
	private static boolean fileIO = false, memory = true, isInputUser = false;
	FastReader in; static PrintWriter out;
	
	void hold(boolean b)throws Exception{if(!b)throw new Exception("Hold right there, Sparky!");}
    void exit(boolean b){if(!b)System.exit(0);}
    static void dbg(Object... o){System.err.println(Arrays.deepToString(o));}
    DecimalFormat df = new DecimalFormat("0.00000000000");
    double PI = 3.141592653589793238462643383279502884197169399;
	
	private OCSBootstrapper() { }
	
	public static OCSBootstrapper getInstance() {
		return INSTANCE;
	}

	/**
	 * This class is a template on how to use different DS, Containers, Collection etc. in JAVA.
	 */
	protected void run() throws Exception {
		long ct = System.currentTimeMillis();
		if (fileIO) {
			in = new FastReader("");
			out = new PrintWriter("");
        } else {
        	in = new FastReader();
        	out = new PrintWriter(System.out);
        }
		ocsArray();
		ocsPairs();
		ocsHashMap();
		out.flush();
        out.close();
		System.err.println("Runtime: "+(System.currentTimeMillis() - ct));
	}
	
	private void ocsPairs() {
		pn("ocsPairs...");
		ArrayList<Pair> studentList = new ArrayList<>();
		for(int i=0; i<5; i++) {
			OCSDb data = new OCSDb();
			studentList.add(new Pair(data.getName(), data.getMarks()));
		}
		pn("Student Name \t\t" + "Marks");
		for (Pair pair : studentList) {
			p(pair.getName()+ "\t");
			pn(pair.getMarks());
		}
	}
	/**
	 * <p><b>ocsHashMap</b> explains the use of HashMap in JAVA.
	 * <p>Syntax to define HashMap, <b>HashMap<String, Student> mp = new HashMap<>();</b>
	 * <p>Duplicate keys are not allowed, If you put duplicate key it will override with the last one.
	 * <p>To access a value one must know its key. HashMap is known as HashMap because it uses a technique called <b>Hashing</b>.
	 */
	private void ocsHashMap() {
		pn("HashMap Portal...");
		HashMap<String, Student> studentMap = new HashMap<>();
		for(int i=0; i<5; i++) {
			studentMap.put(i+1+"", new OCSDb().student);
		}
//		studentMap.put("John", new Student("John", 2022001));
//		studentMap.put("Sam", new Student("Sam", "ECE", 2022002));
//		studentMap.put("Tanual", new Student("Tanual", "EEE", 2022098));
//		studentMap.put("Rohan", new Student("Rohan", "CSE", 2022045));
//		
		out.print(studentMap+"\n");
		
		pn("Student details...");
		for (Map.Entry<String, Student> e : studentMap.entrySet()) {
			pn(e.getValue().toString());
		}
		
		studentMap.remove("Sam");
		studentMap.put("Rohan", new Student("Rohan", 2022005));
		
		pn("Removing...");
		pn("Student details after remove operation...");
		for (Map.Entry<String, Student> e : studentMap.entrySet()) {
			pn(e.getValue().toString());
		}
	}
	/**
	 * <p><b>ocsArray</b> explains the use of Array in JAVA.
	 * <p>Syntax to define, 1D array of size N, <b>int arr[] = new int[N];</b>
	 * <p>2D array, <b>int[][] arr = new int[N][];</b>
	 * <p>3D array, <b>int[][][] arr = new int[N][][];</b>
	 */
	void ocsArray() throws Exception {
		out.print("Array Portal...\n");
		//int N = isInputUser? ni() : 3;
//		int A[] = new int[N];
//		for(int i = 0; i< N; i++)A[i] = ni();
//		for (int i : A) {
//			p(i);
//		}
		
		Student student[] = new Student[4];
//		student[0] = new OCSDb().student;
//		student[1] = new OCSDb().student;
//		student[2] = new OCSDb().student;
//		student[3] = new OCSDb().student;
		for(int i=0; i<student.length; i++) {
			student[i] = new OCSDb().student;
		}
		
		for (Student std : student) {
			pn(std.toString());
		}
		
		int B[][] = {
				{12, 4, 8, 9},
				{2, 8, 9},
				{78, 90, 5, 6}
			};
		for (int[] is : B) {
			for (int is2 : is) {
				p(is2);
			}
			//out.print('\n');
			pn(" ");
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		if(memory) {
        	new Thread(null, new Runnable() {
			        			public void run() {
			        				try {
			        					new OCSBootstrapper().run();
			        				}catch(Exception e) {
			        					e.printStackTrace();
			        					System.exit(1);
			        				}
			        			}
        					}, "1", 1 << 28).start();
        } else 
        	new OCSBootstrapper().run();
	}
	
	int find(int[] set, int u){return set[u] = (set[u] == u?u:find(set, set[u]));}
    int digit(long s){int ans = 0;while(s>0){s/=10;ans++;}return ans;}
    long gcd(long a, long b){return (b==0)?a:gcd(b,a%b);}
    int gcd(int a, int b){return (b==0)?a:gcd(b,a%b);}
    int bit(long n){return (n==0)?0:(1+bit(n&(n-1)));}
    void p(Object... o){for(Object oo:o)out.print(oo+" ");}
    void pn(Object... o){for(int i = 0; i< o.length; i++)out.print(o[i]+(i+1 < o.length?" ":"\n"));}
    void pni(Object... o){for(Object oo:o)out.print(oo+" ");out.println();out.flush();}
    String n()throws Exception{return in.next();}
    String nln()throws Exception{return in.nextLine();}
    int ni()throws Exception{return Integer.parseInt(in.next());}
    long nl()throws Exception{return Long.parseLong(in.next());}
    double nd()throws Exception{return Double.parseDouble(in.next());}
    
    class Pair {
    	String name;
    	ArrayList<Integer> marks = new ArrayList<>();
    	
    	public Pair() {}

		public Pair(String name, ArrayList<Integer> marks) {
			super();
			this.name = name;
			this.marks = marks;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public ArrayList<Integer> getMarks() {
			return marks;
		}

		public void setMarks(ArrayList<Integer> marks) {
			this.marks = marks;
		}
    	
    	
    }

}
