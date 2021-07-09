import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class JDBC_excel {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		
		Fillo fillo=new Fillo();
		com.codoid.products.fillo.Connection connection=fillo.getConnection("D:\\4th Year\\NCP\\ncp-xml\\XMLEval\\ExcelCode\\hotelbook.xlsx");

		
		DocumentBuilderFactory docBuilderFactory=DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder=docBuilderFactory.newDocumentBuilder();
		Document doc = docBuilder.parse(new File("D:\\4th Year\\NCP\\ncp-xml\\XMLEval\\hotel.xml"));
		doc.getDocumentElement().normalize();
		System.out.println("Root element of doc is:"+doc.getDocumentElement().getNodeName());
		
		NodeList listOfPersons=doc.getElementsByTagName("customer");
		for ( int i=0; i<listOfPersons.getLength();i++){
			System.out.println("Here");
			Node firstPerson=listOfPersons.item(i);
			if(firstPerson.getNodeType()==Node.ELEMENT_NODE){
				Element firstPersonElement = (Element)firstPerson;
				
				NodeList firstNames=firstPersonElement.getElementsByTagName("FirstName");
				Element fnameElement=(Element)firstNames.item(0);
				NodeList textFNList=fnameElement.getChildNodes();
				String fname=((Node)textFNList.item(0)).getNodeValue().trim();
				
				NodeList lastNames=firstPersonElement.getElementsByTagName("LastName");
				Element lnameElement=(Element)lastNames.item(0);
				NodeList textLNList=lnameElement.getChildNodes();
				String lname=((Node)textLNList.item(0)).getNodeValue().trim();
				
				NodeList phones=firstPersonElement.getElementsByTagName("Phone");
				Element phoneElement=(Element)phones.item(0);
				NodeList textPhoneList=phoneElement.getChildNodes();
				String phone=((Node)textPhoneList.item(0)).getNodeValue().trim();
				
				NodeList tableNums=firstPersonElement.getElementsByTagName("TableNum");
				Element tabElement=(Element)tableNums.item(0);
				NodeList textTabList=tabElement.getChildNodes();
				String table=((Node)textTabList.item(0)).getNodeValue().trim();
				
				NodeList bookdates=firstPersonElement.getElementsByTagName("BookDate");
				Element bdateElement=(Element)bookdates.item(0);
				NodeList textBDList=bdateElement.getChildNodes();
				String bookdate=((Node)textBDList.item(0)).getNodeValue().trim();
				
				NodeList booktimes=firstPersonElement.getElementsByTagName("BookTime");
				Element btimeElement=(Element)booktimes.item(0);
				NodeList textBTList=btimeElement.getChildNodes();
				String booktime=((Node)textBTList.item(0)).getNodeValue().trim();
				
				System.out.println(booktime);
				
				int x = connection.executeUpdate("Insert into Sheet1(FirstName,LastName,Phone,TableNum,BookDate,BookTime,CustType) values('"+fname+"','"+lname+"','"+phone+"','"+table+"','"+bookdate+"','"+booktime+"','Host')");
				System.out.println(x);
				
			}
		}
		
		NodeList listOfInvitees=doc.getElementsByTagName("Invitee");
		for ( int i=0; i<listOfInvitees.getLength();i++){
			System.out.println("Here");
			Node firstInvitee=listOfInvitees.item(i);
			if(firstInvitee.getNodeType()==Node.ELEMENT_NODE){
				Element firstInviteeElement = (Element)firstInvitee;
				
				NodeList firstInviteeNames=firstInviteeElement.getElementsByTagName("FirstName");
				Element fnameInviteeElement=(Element)firstInviteeNames.item(0);
				NodeList textFINList=fnameInviteeElement.getChildNodes();
				String finvname=((Node)textFINList.item(0)).getNodeValue().trim();
				
				NodeList lastInviteeNames=firstInviteeElement.getElementsByTagName("LastName");
				Element lnameInviteeElement=(Element)lastInviteeNames.item(0);
				NodeList textLINList=lnameInviteeElement.getChildNodes();
				String linvname=((Node)textLINList.item(0)).getNodeValue().trim();
				
				NodeList Inviteephones=firstInviteeElement.getElementsByTagName("Phone");
				Element phoneInviteeElement=(Element)Inviteephones.item(0);
				NodeList textPhoneIList=phoneInviteeElement.getChildNodes();
				String invphone=((Node)textPhoneIList.item(0)).getNodeValue().trim();
				
				
				int y = connection.executeUpdate("Insert into Sheet1(FirstName,LastName,Phone,CustType) values('"+finvname+"','"+linvname+"','"+invphone+"','Guest')");
				
			}
		}
		String strQuery="Select * from Sheet1";
		Recordset recordset = connection.executeQuery(strQuery);
		while (recordset.next()){
			System.out.println("Name:"+recordset.getField("FirstName")+" "+recordset.getField("LastName")+" Phone:"+recordset.getField("Phone")+" Table Number:"+recordset.getField("TableNum")+" Booked-Date:"+recordset.getField("BookDate")+" Booked-Time:"+recordset.getField("BookTime"));
		}
		recordset.close();
		connection.close();
	}

}