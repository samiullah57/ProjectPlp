package com.philips.pages;

import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.stdwin.*;
import com.hp.lft.sdk.Desktop;
import com.hp.lft.sdk.stdwin.Button;
import com.hp.lft.sdk.stdwin.ButtonDescription;
import com.hp.lft.sdk.stdwin.Window;

public class LeanFTDialog {

	public static void acceptAllow() {
		
		try {
			Button allowButton = Desktop.describe(Window.class, new WindowDescription.Builder()
					.childWindow(false)
					.ownedWindow(false)
					.windowClassRegExp("SAP_FRONTEND_SESSION")
					.windowTitleRegExp("Equipment upload tool version 04").build())
				.describe(Dialog.class, new DialogDescription.Builder()
					.childWindow(false)
					.ownedWindow(true)
					.nativeClass("#32770")
					.text("SAP GUI Security").build())
				.describe(Button.class, new ButtonDescription.Builder()
					.nativeClass("Button")
					.text("&Allow").build());
			allowButton.highlight();
			allowButton.click();
			
		} catch (GeneralLeanFtException e) {
		}
	}
}
