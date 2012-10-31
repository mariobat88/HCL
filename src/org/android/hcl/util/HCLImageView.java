package org.android.hcl.util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

public class HCLImageView extends ImageView {

	private Path roundedPath;
    private int rounded;
	
	public HCLImageView(Context context) {
		super(context);
		init();
	}

	public HCLImageView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public HCLImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}
	
	private void init(){
		setLayerType(View.LAYER_TYPE_SOFTWARE, null);
		setRounded(10);
	}
	
	public int getRounded() {
		return rounded;
	}
	
	public void setRounded(int rounded) {
		this.rounded = rounded;
		roundedPath = new Path();
		roundedPath.addRoundRect(new RectF(0, 0, getWidth(), getHeight()), rounded, rounded, Path.Direction.CW);

	}
	
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		if(w != oldw || h != oldh){
			roundedPath = new Path();
			roundedPath.addRoundRect(new RectF(0, 0, w, h), rounded, rounded, Path.Direction.CW);
		}
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		canvas.clipPath(roundedPath);
		super.onDraw(canvas);
	}
	
	
}
