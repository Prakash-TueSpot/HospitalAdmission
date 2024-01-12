package com.example.HospitalAdmission.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.HospitalAdmission.model.HospitalModel;
import com.example.HospitalAdmission.service.HospitalService;
import com.example.HospitalAdmission.service.impl.Database.Database;
@Service
public class HospitalServiceImpl implements HospitalService {
	@Override
	public String Hospitaldetails(HospitalModel hosp) {
		try {
			Connection connection = Database.getConnection();
			if (connection != null) {
				String insertQuery = "insert into hospitalservice values('" + hosp.getHospadmissionid() + "','"
						+ hosp.getPatientname() + "','" + hosp.getTypeofdisease() + "','" + hosp.getTypeofroom() + "','"
						+ hosp.getFeesdetails() + "')";
				System.out.println(insertQuery);
				Statement createStatement = connection.createStatement();
				int row = createStatement.executeUpdate(insertQuery);
				if (row >= 1) {
					return "Data Inserted Successfully";

				} else {
					return "Error in Inserting";
				}
			} else {
				return "Internal Server Error";
			}
		}

		catch (Exception e) {
			e.printStackTrace();
			return "Internal Server Error";
		}

	}
	@Override
	public String updatehospitaldetails(HospitalModel updhosp) {
		try {
			Connection con = Database.getConnection();
			if (con != null) {
				String updateQuery = "update hospitalservice SET typeofdisease='" + updhosp.getTypeofdisease()
						+ "',patientname='" + updhosp.getPatientname() + "',typeofroom='" + updhosp.getTypeofroom()
						+ "', feesdetails='" + updhosp.getFeesdetails() + "' where hospadmissionid="
						+ updhosp.getHospadmissionid();
				System.out.println("UpdateQuery" + updateQuery);
				Statement createStatement = con.createStatement();
				int row = createStatement.executeUpdate(updateQuery);
				if (row >= 1) {
					return "Hospital Data Updated Successfully";
				} else {
					return "Internal Server Error";
				}
			} else {
				return "Internal Server Error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	@Override
	public List<HospitalModel> gethosp() {
		List<HospitalModel> c = new ArrayList<HospitalModel>();
		try {
			Connection connection = Database.getConnection();
			if (connection != null) {
				String SelectQuery = "Select * from hospitalservice";
				System.out.println("SelectQuery:" + SelectQuery);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(SelectQuery);
				while (resultSet.next()) {
					int hospadmissionid = resultSet.getInt("hospadmissionid");
					String patientname = resultSet.getString("patientname");
					String typeofdisease = resultSet.getString("typeofdisease");
					String typeofroom = resultSet.getString("typeofroom");
					String feesdetails = resultSet.getString("feesdetails");
					HospitalModel resp = new HospitalModel();
					resp.setHospadmissionid(hospadmissionid);
					resp.setPatientname(patientname);
					resp.setTypeofdisease(typeofdisease);
					resp.setTypeofroom(typeofroom);
					resp.setFeesdetails(feesdetails);
					c.add(resp);
					System.out.println("hospadmissionid:" + hospadmissionid);
					System.out.println("pateient name:" + patientname);
					System.out.println("typeofdisease:" + typeofdisease);// ");
				}

			} else {
				System.out.println("Internal Server Error");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}
@Override
	public String deleteuser(Integer Id) {
		try {
			Connection con = Database.getConnection();
			if (con != null) {
				String deleteQuery = "delete from hospitalservice where hospadmissionid=" + Id;
				System.out.println("DeleteQuery:" + deleteQuery);
				PreparedStatement preparedStatement = con.prepareStatement(deleteQuery);
				int rowsAffected = preparedStatement.executeUpdate();
				//
				if (rowsAffected > 0) {
					return "Records deleted successfully";
				} else {
					return "No records found for the given hospitaladmissionid : "+Id;
				}

			} else {
				return "Error in getting a database connection";

			}

		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
}
