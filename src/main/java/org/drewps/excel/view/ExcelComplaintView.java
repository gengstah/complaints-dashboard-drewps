package org.drewps.excel.view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.drewps.domain.Complaint;
import org.springframework.web.servlet.view.document.AbstractExcelView;

public class ExcelComplaintView extends AbstractExcelView {
	private static final DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	private static final String[] headers = { "Number", "Ticket #",
			"Complaint Title", "Date", "Remarks & Analysis",
			"Responsible Team", "Status", "Endorser" };
	
	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		@SuppressWarnings("unchecked")
		List<Complaint> openComplaints = (List<Complaint>) model.get("openComplaints");
		@SuppressWarnings("unchecked")
		List<Complaint> closedComplaints = (List<Complaint>) model.get("closedComplaints");
		
		HSSFSheet sheet = workbook.createSheet("Complaints");
		HSSFRow openComplaintsStatusHeader = sheet.createRow(0);
		openComplaintsStatusHeader.createCell(0).setCellValue("Pending complaints");
		HSSFRow openComplaintsHeader = sheet.createRow(1);
		for(int i=0;i<headers.length;i++) {
			openComplaintsHeader.createCell(i).setCellValue(headers[i]);
		}
		
		int rowNum = 2;
		int number = 1;
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setWrapText(true);
		for(Complaint complaint : openComplaints) {
			HSSFRow row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(number++);
			row.createCell(1).setCellValue(complaint.getTicketNo());
			row.createCell(2).setCellValue(complaint.getClient());
			row.createCell(3).setCellValue(dateFormat.format(complaint.getDate()));
			
			HSSFCell remarksAndAnalysis = row.createCell(4);
			remarksAndAnalysis.setCellValue(complaint.getRemarksAndAnalysis());
			remarksAndAnalysis.setCellStyle(cellStyle);
			
			row.createCell(5).setCellValue(complaint.getResponsibleTeam());
			row.createCell(6).setCellValue(complaint.getStatus() + " (" + complaint.getDaysPassed() + "d)");
			row.createCell(7).setCellValue(complaint.getRsagOwner());
		}
		
		sheet.createRow(rowNum++);
		HSSFRow closedComplaintsStatusHeader = sheet.createRow(rowNum++);
		closedComplaintsStatusHeader.createCell(0).setCellValue("Closed complaints");
		HSSFRow closedComplaintsHeader = sheet.createRow(rowNum++);
		for(int i=0;i<headers.length;i++) {
			closedComplaintsHeader.createCell(i).setCellValue(headers[i]);
		}
		
		number = 1;
		for(Complaint complaint : closedComplaints) {
			HSSFRow row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(number++);
			row.createCell(1).setCellValue(complaint.getTicketNo());
			row.createCell(2).setCellValue(complaint.getClient());
			row.createCell(3).setCellValue(dateFormat.format(complaint.getDate()));
			row.createCell(4).setCellValue(complaint.getRemarksAndAnalysis());
			row.createCell(5).setCellValue(complaint.getResponsibleTeam());
			row.createCell(6).setCellValue(complaint.getStatus());
			row.createCell(7).setCellValue(complaint.getRsagOwner());
		}
		
		for(int i=0;i<headers.length;i++) {
			sheet.autoSizeColumn(i);
		}
	}
}
