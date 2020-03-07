package data;

public interface CustomerConstants {
	 String FILENAME_TEXT = "CustomerInfo.txt";
	 String FILENAME_BIN = "CustomerInfo.dat";
	 String FIELD_SEP = "\t";
	 String FILENAME_BIN_FIXED="CustomerInfoFixed.dat";
	 int FIRST_NAME_SIZE=25;
	 int LAST_NAME_SIZE=25;
	 int PHONE_NUM_SIZE=25;
	 int ADDRESS_SIZE=25;
	 int CITY_SIZE=8;
	 int PROVINCE_SIZE=25;
	 int COUNTRY_SIZE=25;
	 int CUSTOMER_ID_SIZE=8;	 
	 int ZIP_SIZE = 25;
	 int RECORD_SIZE=FIRST_NAME_SIZE*2+LAST_NAME_SIZE*2+PHONE_NUM_SIZE*2+ADDRESS_SIZE*2+CITY_SIZE+PROVINCE_SIZE*2+
			 COUNTRY_SIZE*2+CUSTOMER_ID_SIZE+ZIP_SIZE*2;
}
