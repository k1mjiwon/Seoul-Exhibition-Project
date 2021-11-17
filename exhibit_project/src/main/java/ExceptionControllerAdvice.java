import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionControllerAdvice {
	        @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
	        public String handlerIndexException(ArrayIndexOutOfBoundsException e) {
	            System.err.println(e.getClass());
	            return "/redirect:";
	        }
	        
	        @ExceptionHandler(DataIntegrityViolationException.class)
	        public String handlerDIVException(DataIntegrityViolationException e) {
	        	System.err.println(e.getClass());
	            return "/redirect:";
	        }
	        
	        @ExceptionHandler(RuntimeException.class)
	        public ModelAndView handleRuntimeException(RuntimeException e) {
	            ModelAndView mav = new ModelAndView("exception");
	            mav.addObject("errName", e.getClass().getSimpleName());
	            mav.addObject("errMsg", e.getMessage());
	            return mav;
	        }
	        
	        @ExceptionHandler(Exception.class)
	        public void handleException(Exception e) {
	            System.out.println("exception");
	        }
}
