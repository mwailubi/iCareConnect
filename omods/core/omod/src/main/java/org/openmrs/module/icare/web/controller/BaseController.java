package org.openmrs.module.icare.web.controller;

public class BaseController {
	
	/*protected final Log log = LogFactory.getLog(getClass());
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public Map<String, Object> handleError(HttpServletRequest req, Exception ex) {
		log.error("Request: " + req.getRequestURL() + " raised " + ex);
		Map<String, Object> errorMessage = new HashMap<String, Object>();
		errorMessage.put("message", ex.toString());
		errorMessage.put("status", "ERROR");
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		ex.printStackTrace(pw);
		String sStackTrace = sw.toString(); // stack trace as a string
		errorMessage.put("details", sStackTrace);
		return errorMessage;
	}*/
}
