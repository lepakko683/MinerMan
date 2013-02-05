package minerMan.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DateEvents {
	List<DateEvent> devents = new ArrayList<DateEvent>();
	final String netlocation = "https://raw.github.com/lepakko683/LeCraft/master/DateEvents.txt";
	
	public DateEvents(){
		List<String> strIn = new ArrayList<String>();
		URL net;
		BufferedReader br;
		try{
			net = new URL(netlocation);
			br = new BufferedReader(new InputStreamReader(net.openStream()));
			String srIn;
			do{
				srIn = br.readLine();
				if(srIn != null){
					strIn.add(srIn);
				}
			}while(srIn != null);
			br.close();
		}catch(MalformedURLException mfurle){
			mfurle.printStackTrace();
		}catch(IOException ioex){
			ioex.printStackTrace();
		}finally{
			//System.out.println("finally");
		}
		
		String e = "6:7";
		if(strIn.size()>0){
			for(String out : strIn){
				String[] props = out.split(":");
				DateEvent dea = new DateEvent(props[2],props[3],props[1]);
				dea.setDesc(props[4]);
				devents.add(dea);
				//dea.isActive();
				System.out.println(dea.toString());
			}
		}
		
	}
}
