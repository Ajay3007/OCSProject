package ocs.bootstrap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FastReader {

    BufferedReader br;
    StringTokenizer st;
    public FastReader(){
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public FastReader(String s) throws Exception{
        br = new BufferedReader(new FileReader(s));
    }

    String next() throws Exception{
        while (st == null || !st.hasMoreElements()){
            try{
                st = new StringTokenizer(br.readLine());
            }catch (IOException  e){
                throw new Exception(e.toString());
            }
        }
        return st.nextToken();
    }

    String nextLine() throws Exception{
        String str;
        try{
            str = br.readLine();
        }catch (IOException e){
            throw new Exception(e.toString());
        }
        return str;
    }

}
