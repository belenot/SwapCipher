package com.belenot.mgupi.practice;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import java.util.Arrays;


public class MainSceneController {
	@FXML
	private Button encodeBtn;
	@FXML
	private Button decodeBtn;
	@FXML
	TextField messageTF;
	@FXML
	TextField keyTF;

	@FXML
    private void encodeBtnClick(ActionEvent event) {
		String message = messageTF.getText();
		String key = keyTF.getText();
		String encoded = "";
		try {
			encoded = new String(SwapCipher.encode(message.toCharArray(), Arrays.stream(key.split(",")).mapToInt( s -> Integer.parseInt(s)).toArray()));
			messageTF.setText(encoded);
		} catch (IllegalArgumentException exc) {
			exc.printStackTrace();
			messageTF.setText("Wrong parameters");
		}
	}

	@FXML
	private void decodeBtnClick(ActionEvent event) {
		String message = messageTF.getText();
		String key = keyTF.getText();
		String decoded = "";
		try {
		    decoded = new String(SwapCipher.decode(message.toCharArray(), Arrays.stream(key.split(",")).mapToInt( s -> Integer.parseInt(s)).toArray()));
			messageTF.setText(decoded);
		} catch (IllegalArgumentException exc) {
			exc.printStackTrace();
			messageTF.setText("Wrong parameters");
		}
	}
				
}
