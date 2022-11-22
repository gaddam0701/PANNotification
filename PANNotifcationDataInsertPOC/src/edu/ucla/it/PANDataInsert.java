package edu.ucla.it;

import java.sql.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class PANDataInsert {
	static final String DB_URL = "jdbc:db2://zos.ais.ucla.edu:446/DB2T";
	static final String USER = "temga";
	static final String PASS = "Sap@2018";

	public static void main(String[] args) {
		Timestamp ts = Timestamp.from(Instant.now());
		StringBuilder noticeId = new StringBuilder();
		noticeId.append(ts.toString());
		noticeId.reverse();
		System.out.println(noticeId);
		// Open a connection
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();) {
			// Execute Insert queries
			// insertDataInPNXTable(stmt);
			// insertDataInPNYTable(stmt);
			// insertDataInPNRTable(stmt);
			//insertDataInPNATable(stmt);
			//insertDataInPNHTable(stmt);
			//insertDataInPNTTable(stmt);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insertDataInPNHTable(Statement stmt) {
		for (String htmlData : getSamplePNHData()) {
			try {

				System.out.println("Inserting records into the PNH table...");
				String sql = "INSERT INTO DB2T.PP0TST.UC0VZPNH_PNH VALUES "
						// + "('"+noticeId.substring(1)+ "','N','1',1,'HTML Test Data')";
						+ "('000103.62.14.61-71-11-2202','N','1',1,'"+htmlData+"')";
				stmt.executeUpdate(sql);

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void insertDataInPNTTable(Statement stmt) {
		int lineNum = 1040;
		for (String htmlData : getSamplePNTData()) {
			try {

				System.out.println("Inserting records into the PNT table...");
				String sql = "INSERT INTO DB2T.PP0TST.UC0VZPNT_PNT VALUES "
						// + "('"+noticeId.substring(1)+ "','N','1',1,'HTML Test Data')";
						+ "('000103.62.14.61-71-11-2202','N'," +lineNum+",'"+htmlData+"')";
				stmt.executeUpdate(sql);
				lineNum++;

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void insertDataInPNATable(Statement stmt) {
		int lineNum = 1;
		try {
			System.out.println("Inserting records into the PNA table...");
			String sql = "INSERT INTO DB2T.PP0TST.UC0VZPNA_PNA VALUES "
					// + "('"+noticeId.substring(1)+ "','N','1',1,'HTML Test Data')";
					+ "('000103.62.14.61-71-11-2202',"+lineNum+",'R','E','SUSAN.GUTMAN@ANDERSON.UCLA.EDU','GUTMAN, SUSAN','PUR','Y',CURRENT TIMESTAMP,'Y','','MPSG0','GUTMAN','SUSAN','','0001-01-01 00:00:00.0')";
			stmt.executeUpdate(sql);
			lineNum++;
			sql = "INSERT INTO DB2T.PP0TST.UC0VZPNA_PNA VALUES "
					// + "('"+noticeId.substring(1)+ "','N','1',1,'HTML Test Data')";
					+ "('000103.62.14.61-71-11-2202',"+lineNum+",'M','E','SRICHMAN@AIS.UCLA.EDU','RICHMAN, STEVE','PUR','Y',CURRENT TIMESTAMP,'Y','','MPSG0','GUTMAN','SUSAN','','0001-01-01 00:00:00.0')";
			stmt.executeUpdate(sql);
			lineNum++;
			sql = "INSERT INTO DB2T.PP0TST.UC0VZPNA_PNA VALUES "
			// + "('"+noticeId.substring(1)+ "','N','1',1,'HTML Test Data')";
			+ "('000103.62.14.61-71-11-2202',"+lineNum+",'X','E','SFONG@AIS.UCLA.EDU','FONG, SINYU','PUR','Y',CURRENT TIMESTAMP,'Y','','FSSF0','FONG','SINYU','','0001-01-01 00:00:00.0')";
	        stmt.executeUpdate(sql);
	    	lineNum++;
			sql = "INSERT INTO DB2T.PP0TST.UC0VZPNA_PNA VALUES "
			// + "('"+noticeId.substring(1)+ "','N','1',1,'HTML Test Data')";
			+ "('000103.62.14.61-71-11-2202',"+lineNum+",'U','E','MGADDAM@IT.UCLA.EDU','GADDAM, MUKUNDA','PUR','Y',CURRENT TIMESTAMP,'Y','','TEMGA','GADDAM','MUKUNDA','','0001-01-01 00:00:00.0')";
	


		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insertDataInPNXTable(Statement stmt) {
		try {
			System.out.println("Inserting records into the PNX table...");
			String sql = "INSERT INTO DB2T.PP0TST.UC0VZPNX_PNX VALUES "
					+ "('000103.62.14.61-71-11-2202','C','TEMGA','','PUR','',"
					+ "CURRENT TIMESTAMP,99,0,99,'PUR','0000374-7748109014-01',"
					+ "'PAYMENT FOR AUTHROIZED BUSINESS TRAVEL',"
					+ "'','','','','','','','','','','','','','','','','','','','','')";
			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insertDataInPNYTable(Statement stmt) {
		try {
			System.out.println("Inserting records into the PNY table...");
			String sql = "INSERT INTO DB2T.PP0TST.UC0VZPNY_PNY VALUES "
					+ "('000103.62.14.61-71-11-2202',1,CURRENT DATE,100.00,"
					+ "'4','400987','5A','64340','','03','2000','LOMING','1160','1161','1165','0300')";

			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insertDataInPNRTable(Statement stmt) {
		try {
			System.out.println("Inserting records into the PNR table...");
			String sql = "INSERT INTO DB2T.PP0TST.UC0VZPNR_PNR VALUES "
					// + "('"+noticeId.substring(1)+ "','N','1',1,'HTML Test Data')";
					+ "('000103.62.14.61-71-11-2202','030000','Test Dept Description')";
			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<String> getSamplePNHData() {
		List<String> pnhData = new ArrayList<String>();
		pnhData.add("<TABLE><TR> ");
		pnhData.add("<TABLE BORDER=\"0\" CELLPADDING=\"0\" CELLSPACING=\"0\" WIDTH=\"100%\">              ");
		pnhData.add(
				"<TR><TD COLSPAN=\"9\">                                                                                                                        </TD></TR>");
		pnhData.add(
				"<TR><TD COLSPAN=\"9\">  approved by the designated reviewers(s).                                                                              </TD></TR>");
		pnhData.add(
				"<TR><TD COLSPAN=\"9\">                                                                                                                        </TD></TR>");
		pnhData.add(
				"<TR><TD COLSPAN=\"9\">  If there is any discrepancy between your records and this information,                                                </TD></TR>");
		pnhData.add(
				"<TR><TD COLSPAN=\"9\">  or if you have other concerns related to this reimbursement, you                                                      </TD></TR>");
		pnhData.add(
				"<TR><TD COLSPAN=\"9\">  should call Travel Accounting at (310)-206-2639, Option 4, immediately                                                </TD></TR>");
		pnhData.add(
				"<TR><TD COLSPAN=\"9\">                                                                                                                        </TD></TR>");
		pnhData.add(
				"<TR><TD COLSPAN=\"9\">                                                                                                                        </TD></TR>");
		pnhData.add(
				"<TR><TD COLSPAN=\"9\">************************************************************************************************************************</TD></TR>");
		pnhData.add(
				"<TR><TD>LOC       </TD><TD>ACCOUNT   </TD><TD>CC        </TD><TD>FUND      </TD><TD>PROJECT   </TD><TD>SUB       </TD><TD>OBJECT    </TD><TD>SOURCE    </TD><TD>AMOUNT         </TD></TR>");
		pnhData.add(
				"<TR><TD>4         </TD><TD>400987    </TD><TD>5A        </TD><TD>64340     </TD><TD>          </TD><TD>03        </TD><TD>2000      </TD><TD>LOMING    </TD><TD>       $595.64 </TD></TR>");
		pnhData.add(
				"<TR><TD COLSPAN=\"9\">************************************************************************************************************************</TD></TR>");
		pnhData.add(
				"<TR><TD COLSPAN=\"9\">                                                                                                                        </TD></TR>");
		pnhData.add(
				"<TR><TD COLSPAN=\"2\">PTA NUMBER:         </TD><TD COLSPAN=\"3\">0000374-7748109014-01         </TD><TD COLSPAN=\"2\">PAYMENT DATE:       </TD><TD COLSPAN=\"2\">04/01/2010                    </TD></TR>");
		pnhData.add(
				"<TR><TD COLSPAN=\"9\">TRIP TITLE: LOMINGER TRAINING                                                                                           </TD></TR>");
		pnhData.add(
				"<TR><TD COLSPAN=\"9\">TRAVELER NAME: SARAH SCHAAR                                                                                             </TD></TR>");
		pnhData.add(
				"<TR><TD COLSPAN=\"9\">TRAVEL DATE: 11/28/2022                                                                                                 </TD></TR>");
		pnhData.add(
				"<TR><TD COLSPAN=\"9\">RETURN DATE: 11/31/2022                                                                                                 </TD></TR>");
		pnhData.add(
				"TR><TD COLSPAN=\"9\">FROM (CITY): MSP                                                                                                        </TD></TR>");
		pnhData.add(
				"<TR><TD COLSPAN=\"9\">DESTINATION (CITY): LAX                                                                                                 </TD></TR> ");
		pnhData.add(
				"<TR><TD COLSPAN=\"9\">========================================================================================================================</TD></TR>");
		pnhData.add(
				"<TR><TD COLSPAN=\"2\">AMOUNT              </TD><TD COLSPAN=\"3\">EXPENSE TYPE                  </TD><TD COLSPAN=\"2\">                    </TD><TD COLSPAN=\"2\">  ");
		pnhData.add(
				"<TR><TD COLSPAN=\"2\">--------------------</TD><TD COLSPAN=\"3\">------------------------------</TD><TD COLSPAN=\"2\">                    </TD><TD COLSPAN=\"2\">");
		pnhData.add(
				"<TR><TD COLSPAN=\"2\">       $595.64 </TD><TD COLSPAN=\"3\">7748109014-TICKET FEES-LOMINGE</TD><TD COLSPAN=\"2\">");
		return pnhData;
	}
	
	public static List<String> getSamplePNTData() {
		List<String> pnhData = new ArrayList<String>();
		pnhData.add("                                                                              ");
		pnhData.add("The following payment for authorized business travel was    ");
		pnhData.add("approved by the designated reviewers(s).");
		pnhData.add("                                                                             ");
		pnhData.add("If there is any discrepancy between your records and this information,     ");
		pnhData.add("or if you have other concerns related to this reimbursement, you       ");
		pnhData.add("should call Travel Accounting at (310)-206-2639, Option 4, immediately  ");
		pnhData.add("                                                                              ");
		pnhData.add("                                                                              ");
		pnhData.add("*******************************************************************************");
		pnhData.add("LOC ACCOUNT CC FUND  PROJECT SUB OBJECT SOURCE          AMOUNT                 ");
		pnhData.add("4   400987  5A 64340         03  2000   LOMING        $595.64                  ");
		pnhData.add("*******************************************************************************");
		pnhData.add("PTA NUMBER: 0000374-7748109014-0  PAYMENT DATE: 04/01/2010                     ");
		pnhData.add("TRIP TITLE: LOMINGER TRAINING                                                  ");
		pnhData.add("TRAVELER NAME: SARAH SCHAAR                                                    ");
		pnhData.add("TRAVEL DATE: 03/28/2010                                                        ");
		pnhData.add("RETURN DATE: 03/31/2010                                                        ");
		pnhData.add("FROM (CITY): MSP                                                               ");
		pnhData.add("DESTINATION (CITY): LAX                                                        ");
		pnhData.add("===============================================================================");
		pnhData.add("AMOUNT         EXPENSE TYPE                                                    ");
		pnhData.add("----------     -------------------------------                                 ");
		pnhData.add("   $595.64     7748109014-TICKET FEES-LOMINGER TRAINING                        ");
		pnhData.add("----------     -------------------------------     ");
		pnhData.add("   $595.64     TOTAL    ");
		return pnhData;
	}	
}
