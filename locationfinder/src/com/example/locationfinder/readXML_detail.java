package com.example.locationfinder;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.util.Log;

public class readXML_detail {
	String data = "";
	PlaceDetail detail = new PlaceDetail();
	PlaceDetail XMLread(String reference,String APIKEY){
		try{
			
			InputStream is = getConnection("https://maps.googleapis.com/maps/api/place/details/xml?key="AIzaSyA6WQJtCGxO4Yow-VXnH0NfkuXsPTBipH8"&reference="+reference+"&sensor=false");
			
			
			DefaultHandler handler = new DefaultHandler(){

				@Override
				public void startElement(String uri, String localName,
						String qName, Attributes attributes)
						throws SAXException {
					// TODO Auto-generated method stub
					super.startElement(uri, localName, qName, attributes);
				}
				
				@Override
				public void characters(char[] ch, int start, int length)
						throws SAXException {
				data = new String(ch, start,length);	
					super.characters(ch, start, length);
				}

				@Override
				public void endElement(String uri, String localName,
						String qName) throws SAXException {
					
					if (qName.equalsIgnoreCase("name")) {
					detail.setname(data);	
					}
					
					if (qName.equalsIgnoreCase("vicinity")) {
						detail.setvicinity(data);	
						}
					if (qName.equalsIgnoreCase("formatted_address")) {
						detail.setaddress(data);	
						}
					if (qName.equalsIgnoreCase("international_phone_number")) {
						detail.setphone(data);	
						}
					if (qName.equalsIgnoreCase("rating")) {
						detail.setrating(data);	
						}
					
					super.endElement(uri, localName, qName);
				}

				
				
				
			};
			
			 SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
				parser.parse(is, handler);
			
			
			
			
		}catch(Exception e){
			
		}
	return detail;	
		
	}
	public static  InputStream getConnection(String url) {
		InputStream is = null;
		try {
			URLConnection conn = new URL(url).openConnection();
			conn.setConnectTimeout(10000);
            conn.setReadTimeout(10000);
			is = conn.getInputStream();
		} catch (MalformedURLException e) {
			Log.i("uo", "exception2");
		} catch (IOException e) {
			Log.i("uo", "exception3");
		}
		return is;
	}

}
