package com.test.customview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class FlowLayout extends ViewGroup {
    public FlowLayout(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -1);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), paramAttributeSet);
    }

    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
        return new ViewGroup.MarginLayoutParams(paramLayoutParams);
    }

    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        int count=getChildCount();
        int lineHeight = 0;
        //记录每一行的宽度
        int lineWidth = 0;
        int top = 0;
        int left = 0;
        for (byte i = 0; i < count; i++) {
            View child = getChildAt(i);
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams)child.getLayoutParams();
            int childWidth = child.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
            int childHeight = child.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
            if (lineWidth + childWidth > getMeasuredWidth()) {
                top += lineHeight;
                left = 0;
                lineHeight = childHeight;
                lineWidth = childWidth;
            } else {
                lineHeight = Math.max(lineHeight, childHeight);
                lineWidth += childWidth;
            }
            int lc = left + marginLayoutParams.leftMargin;
            int tc = top + marginLayoutParams.topMargin;
            child.layout(lc, tc, lc + child.getMeasuredWidth(), tc + child.getMeasuredHeight());
            left += childWidth;
        }
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMeasureSpecSize = View.MeasureSpec.getSize(widthMeasureSpec);
        int heightMeasureSpecSize = View.MeasureSpec.getSize(heightMeasureSpec);
        int widthMeasureSpecMode = View.MeasureSpec.getMode(widthMeasureSpec);
        int heightMeasureSpecMode = View.MeasureSpec.getMode(heightMeasureSpec);
        int lineHeight = 0;
        int lineWidth = 0;
        int width = 0;
        int height = 0;
        int childCount = getChildCount();
        for (int i=0;i < childCount;i++) {
            View child = getChildAt(i);
            measureChild(child, widthMeasureSpec, heightMeasureSpec);
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams)child.getLayoutParams();
            int i9 = heightMeasureSpecSize;
            int childWidth = marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + child.getMeasuredWidth();
            int i12 = childCount;
            int childHeight = marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + child.getMeasuredHeight();
            if (lineWidth + childWidth > widthMeasureSpecSize) {
                width=Math.max(lineWidth,width);
                height+=lineHeight;
                lineHeight=childHeight;
                lineWidth=childWidth;
            } else {
                lineHeight=Math.max(lineHeight,childHeight);
                lineWidth+=childWidth;
            }
            if (i==childCount-1){
                height+=lineHeight;
                width=Math.max(width,lineWidth);
            }
        }
        setMeasuredDimension((widthMeasureSpecMode==MeasureSpec.EXACTLY)?widthMeasureSpecSize:width,
                (heightMeasureSpecMode==MeasureSpec.EXACTLY)?heightMeasureSpecSize:height);
    }
}
