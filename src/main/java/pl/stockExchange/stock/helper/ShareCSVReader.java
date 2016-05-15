package pl.stockExchange.stock.helper;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.stockExchange.stock.model.to.CompanyTo;
import pl.stockExchange.stock.model.to.ShareTo;

public class ShareCSVReader {

	public List<CompanyTo> getDataForCompanyTo(String filePath) throws IOException {
		Long id = 0L;
		List<ShareTo> shareList = new ArrayList<>();
		HashMap<String, List<ShareTo>> shares = new HashMap<>();

		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
			String line;

			while ((line = bufferedReader.readLine()) != null) {
				String[] data = line.split(",");
				if (data.length == 3) {
					String companyName = data[0];
					Date date = string2date(data[1]);
					String price = data[2];
					shareList = shares.get(companyName);
					if (shareList == null) {
						//shareList.clear();
						shareList = new ArrayList<>();
						shares.put(companyName, shareList);
					}
					shareList.add(new ShareTo(null, null, new BigDecimal(price), date));

				}
			}
			bufferedReader.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<CompanyTo> compList = shares.entrySet().stream()
				.map(entry -> new CompanyTo(null, entry.getKey(), entry.getValue())).collect(Collectors.toList());
		return compList;
	}

	// public List<ShareTo> getDataForShareTo(String filePath) throws
	// IOException {
	// Long id = 0L;
	// List<CompanyTo> company = getDataForCompanyTo(filePath);
	// List<ShareTo> share = new ArrayList<>();
	// try {
	// BufferedReader bufferedReader = new BufferedReader(new
	// FileReader(filePath));
	// String line;
	// while ((line = bufferedReader.readLine()) != null) {
	// String[] data = line.split(",");
	// if (data.length == 3) {
	// Double price = Double.parseDouble(data[2]);
	// id++;
	// String companyName = data[0];
	// Date date = string2date(data[1]);
	// for (CompanyTo comp : company) {
	// if (companyName.equals(comp.getCompanyName())) {
	// share.add(new ShareTo(id, comp, price, date));
	// }
	// }
	//
	// }
	// }
	// bufferedReader.close();
	// } catch (FileNotFoundException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// return share;
	// }

	private static Date string2date(String sDate) {
		SimpleDateFormat formater = new SimpleDateFormat("yyyyMMdd");
		try {
			return formater.parse(sDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
