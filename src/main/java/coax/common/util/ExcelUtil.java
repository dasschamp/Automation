package coax.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtil {
	
	static Logger log = LogManager.getLogger(ExcelUtil.class.getName());

	private static String strTestDatapath = new StringBuilder().append(Constants.RESOURCES_FOLDER)
			.append(File.separator).append(Constants.TESTDATA_FOLDER).append(File.separator).toString();

	private static FileInputStream fileIn = null;
	private static FileOutputStream fileout = null;
	private static Workbook wb;
	private static Sheet sheet;
	private static Cell cell;
	private static Row row;

	public static void setExcelFile(String Workbook, String SheetName) {

		String strBook = strTestDatapath + Workbook;

		try {
			fileIn = new FileInputStream(strBook);
			
			if (FilenameUtils.getExtension(strBook).equalsIgnoreCase("XLS")) {
				wb = new HSSFWorkbook(fileIn);
			} else if (FilenameUtils.getExtension(strBook).equalsIgnoreCase("XLSX")) {
				wb = new XSSFWorkbook(fileIn);
			}

			sheet = wb.getSheet(SheetName);
			fileIn.close();
		}

		catch (Exception e) {
			log.error(e);
		}

	}
	
	public static String getData(String ColName) {
		String strValue = ColName;
		String strPattern = "TD:";

		try {
			if(ColName.contains(strPattern)){
				strValue = ColName.split(strPattern)[1];
				strValue = getCellData(strValue);
			}else{
					strValue = ColName;
			}
		} catch (Exception e) {
			log.error(e);
		}

		return strValue;
	}
	

	public static String getCellData(String ColName) {

		String CellData = null;

		try {

			row = sheet.getRow(0);

			int col_Num = -1;

			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equals(ColName))
					col_Num = i;
			}

			if (col_Num == -1)
				return "Column name is not found";

			cell = sheet.getRow(1).getCell(col_Num);

			CellData = cell.getStringCellValue();

		}

		catch (Exception e) {
			log.error(e);
		}

		return CellData;

	}

	public static void setCellData(String colName, String data) throws Exception {

		try {

			row = sheet.getRow(0);

			int colNum = -1;

			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equals(colName))
					colNum = i;
			}

			cell = sheet.getRow(1).getCell(colNum);

			cell.setCellValue(data);

			fileout = new FileOutputStream(strTestDatapath);

			wb.write(fileout);

			fileout.close();

		}

		catch (Exception e) {
			log.error(e);

		}

	}

}
