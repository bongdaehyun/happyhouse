package util;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import com.ssafy.happyhouse.dto.myArea;

public class ParsingCsv {

	public static void main(String[] args)throws Exception {
		String path=System.getProperty("user.dir");
		File file=new File(path+"\\csv\\소상공인시장진흥공단_상가(상권)정보_서울_202012.csv");
		DBUtil util=DBUtil.getInstance();
		
		BufferedReader in=new BufferedReader(new FileReader(file));
		String line="";
		ArrayList<myArea>areas=new ArrayList<>();
		
		int count=0;
		while((line=in.readLine()) !=null) {
			myArea area=new myArea();
			if(count++==0) {
				continue;
			}
			String s[]=line.split("\\|");
			for(int i=0;i<s.length;i++) {
				
				if(i==8) {
					area.setTypeName(s[i]);
				}
				else if(i==17) {
					//System.out.println(s[i]);
					area.setDongCode(s[i]);
				}
				else if(i==16) {
					area.setDong(s[i]);
				}
				else if(i==30) {
					area.setName(s[i]);
				}else if(i==38) {
					//위도
					area.setLat(s[i]);
				}else if(i==37) {
					//경도
					area.setLng(s[i]);
				}
				
			}		
			areas.add(area);
		}
		//System.out.println(areas.size());
		
		String sql=" insert into areainfo (dongcode,typename,name,dong,lat,lng) Values (?,?,?,?,?,?)";
		
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
			con=util.getConnection();
			for(myArea my:areas) {
				ps=con.prepareStatement(sql);
				ps.setString(1, my.getDongCode());
				ps.setString(2, my.getTypeName());
				ps.setString(3, my.getName());
				ps.setString(4, my.getDong());
				ps.setString(5, my.getLat());
				ps.setString(6, my.getLng());
				
				ps.executeUpdate();
				
			}
			
		}finally {
			util.close(con,ps);
		}
		
	}
}
