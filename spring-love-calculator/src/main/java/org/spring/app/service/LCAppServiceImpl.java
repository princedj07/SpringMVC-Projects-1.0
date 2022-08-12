package org.spring.app.service;

import org.spring.app.utility.LoveCalculatorConstats;
import org.springframework.stereotype.Service;

@Service
public class LCAppServiceImpl implements LCAppService {

	public final String LOVE_FORMULA = "FLAME";

	@Override
	public String calculateLove(String userName, String crushName) {

		System.out.println("UserName------: " + userName);
		System.out.println("CrushName-----: " + crushName);

		int userAndcrushNameCount = (userName + crushName).toCharArray().length;
		int formulaCount = LOVE_FORMULA.toCharArray().length;

		int remainder = userAndcrushNameCount % formulaCount;

		char resultChar = LOVE_FORMULA.charAt(remainder);
		System.out.println("LCAppServiceImpl.calculateLove()----: " + resultChar);

		String result = whatsBetweenUs(resultChar);

		return result;
	}

	@Override
	public String whatsBetweenUs(char calculationResult) {

		String result = "";

		if (calculationResult == 'F') {
			result = LoveCalculatorConstats.F_CHAR_MEANING;
		} else if (calculationResult == 'L') {
			result = LoveCalculatorConstats.L_CHAR_MEANING;
		} else if (calculationResult == 'A') {
			result = LoveCalculatorConstats.A_CHAR_MEANING;
		} else if (calculationResult == 'M') {
			result = LoveCalculatorConstats.M_CHAR_MEANING;
		} else if (calculationResult == 'E') {
			result = LoveCalculatorConstats.E_CHAR_MEANING;
		} else if (calculationResult == 'S') {
			result = LoveCalculatorConstats.S_CHAR_MEANING;
		}

		return result;
	}

}
