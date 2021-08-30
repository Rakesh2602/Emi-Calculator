import java.sql.*;


public class AddDetail {
	public boolean registerDetail(Bean sib){
		boolean status=false;
		Integer id=sib.getId();
		String userid=sib.getUsername();
		Integer loan_tenure=sib.getEnterthenumberofmonths();
		Double rate_of_interest=sib.getEntertheniterestrate();
		Integer loan_amount=sib.getEntertheamount();
		Double total_interest=sib.getInterestpayable();
		Double total_amount=sib.getTotalpayment();
		Double interest_permonth=sib.getFinalValue();



		Connection con=null;



		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","rakesh","rakesh");
			Statement st=con.createStatement();
			int i = st.executeUpdate("insert into hdfc values("+loan_amount+","+rate_of_interest+","+loan_tenure+",'"+userid+"',"+interest_permonth+","+total_interest+","+id+")");
			if(i>0){
				//status=true;
				System.out.println(i);
			}

		}catch(Exception e){
			System.out.print(e);
		}
		return status;
	}
}

