package com.slk.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.slk.dto.Root;

public class ApiTest {

	public Root scrapEquity(int lrr) {
		Root root = null;
		String apiUrl = "https://www.etmoney.com/stocks/list-of-stocks";

		try {
			URL url = new URL(apiUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			connection.setDoOutput(true);

			String param = "isAsync=true&lrr=" + lrr;

			try (DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream())) {
				outputStream.writeBytes(param);
				outputStream.flush();
			}

			int responseCode = connection.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();

				System.out.println(response.toString());
				ObjectMapper mapper = new ObjectMapper();
				root = mapper.readValue(response.toString(), Root.class);

				System.out.println(root);
				System.out.println(root.getResponseDTOList());
				System.out.println(root.getResponseDTOList().get(0));
				System.out.println(root.getResponseDTOList().get(0).getSn());
				System.out.println(root.getLastUpdateTime().getValue());

			} else {
				System.out.println("GET request failed with response code: " + responseCode);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return root;
	}

	public static void main(String[] args) {
		int count = 50;
		for (int i = 50; i <= 1950; i = i + 50) {

			Root root = new ApiTest().scrapEquity(i);

		}
	}
}
