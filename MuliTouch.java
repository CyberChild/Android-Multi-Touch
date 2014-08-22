import java.util.ArrayList;

import android.view.MotionEvent;

public class MultiTouch {
	public String getIdAndLocationOfTouch(MotionEvent event){
		int pointerIndex = event.getActionIndex();
		int pointerId = event.getPointerId(pointerIndex);
		int maskedAction = event.getActionMasked();
		if(maskedAction == MotionEvent.ACTION_DOWN || maskedAction == MotionEvent.ACTION_POINTER_DOWN){
			return "["+pointerId+"][Touched]["+event.getX(pointerIndex)+"]["+event.getY(pointerIndex)+"]";
		}
		else
			return null;
	}
	public String getLocationOfMoved(MotionEvent event, int id){
		String str="[Id Not Found]";
		int maskedAction = event.getActionMasked();
		if(maskedAction == MotionEvent.ACTION_MOVE)
			for(int size = event.getPointerCount(), i=0;i<size;i++){
				if(event.getPointerId(i) == id){
					str = "["+id+"][Moved]["+event.getX(i)+"]["+event.getY(i)+"]";
					break;
				}
			}
		else
			str="[Not Moved]";
		return str;
	}
	public String getIdAndLocationOfRemoved(MotionEvent event){
		int pointerIndex = event.getActionIndex();
		int pointerId = event.getPointerId(pointerIndex);
		int maskedAction = event.getActionMasked();
		if(maskedAction == MotionEvent.ACTION_UP || maskedAction == MotionEvent.ACTION_POINTER_UP || maskedAction == MotionEvent.ACTION_CANCEL || maskedAction == MotionEvent.ACTION_OUTSIDE){
			return "["+pointerId+"][Removed]["+event.getX(pointerIndex)+"]["+event.getY(pointerIndex)+"]";
		}
		else
			return null;
	}
}
