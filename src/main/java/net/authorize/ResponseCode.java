package net.authorize;

import net.authorize.util.StringUtils;

/**
 * Response code indicates the overall status of the transaction
 * with possible values of approved, declined, error, or held for review.
 *
 * @deprecated since version 1.9.8
 * @deprecated We have reorganized and simplified the Authorize.Net API to ease integration and to focus on merchants' needs.
 * @deprecated We have deprecated AIM, ARB, CIM, and Reporting as separate options, in favor of AuthorizeNet::API (package: net.authorize.api.*).
 * @deprecated We have also deprecated SIM as a separate option, in favor of Accept Hosted. See https://developer.authorize.net/api/reference/features/accept_hosted.html for details on Accept Hosted.
 * @deprecated For details on AIM, see https://github.com/AuthorizeNet/sample-code-java/tree/master/src/main/java/net/authorize/sample/PaymentTransactions.
 * @deprecated For details on the deprecation and replacement of legacy Authorize.Net methods, visit https://developer.authorize.net/api/upgrade_guide/.
 *
 */
@Deprecated
public enum ResponseCode {
	APPROVED(1, "This transaction has been approved."),
	DECLINED(2, "This transaction has been declined"),
	ERROR(3, "There has been an error processing this transaction."),
	REVIEW(4, "This transaction is being held for review."),
	UNKNOWN(0, "Unknown.");

	private final int code;
	private final String description;

	private ResponseCode(int code, String description) {
		this.code = code;
		this.description = description;
	}

	/**
	 * Lookup a ResponseCode by it's response code.
	 * @param code
	 *
	 * @return Returns a ResponseCode if a code match is found.
	 */
	public static ResponseCode findByResponseCode(int code) {
		for(ResponseCode responseCode : values()) {
			if(responseCode.code == code) {
				return responseCode;
			}
		}

		return ResponseCode.UNKNOWN;
	}

	/**
	 * Lookup a ResponseCode by it's response code.
	 * @param code
	 *
	 * @return Returns a ResponseCode if a code match is found.
	 */
	public static ResponseCode findByResponseCode(String code) {
		if(StringUtils.isNotEmpty(code)) {
			return findByResponseCode(Integer.parseInt(code));
		}

		return ResponseCode.UNKNOWN;
	}

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

}
