package com.forword.common;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;

public class CircleXY implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	/** 
	 *java已知圆点坐标和半径，得到圆上的点 
	 *CIRCLE_CENTER_X ，CIRCLE_CENTER_Y  圆心坐标 
	 *CIRCLE_R  圆半径 
	 *ANGLE  角度
	 * 
	 * 计算公式：
	 * x = CIRCLE_CENTER_X + CIRCLE_R * cos(ANGLE * 3.14 / 180)
	 * y = CIRCLE_CENTER_Y + CIRCLE_R * sin(ANGLE * 3.14 /180);
	 */ 
	public static List<Point> initPointsCircular(double x_, double y_, double radii, int number) {
		List<Point> points = new LinkedList<Point>();
		double CIRCLE_CENTER_X = x_;     
		double CIRCLE_CENTER_Y = y_;
		double CIRCLE_R = radii;
		double ANGLE = 360 / number;
		
		DecimalFormat df = new DecimalFormat("######0.00");
		
        for (int i = 0; i < number; i += 1) {  
        	double x = Double.parseDouble(df.format((CIRCLE_CENTER_X + CIRCLE_R * Math.sin(Math.PI * (ANGLE * i) / 180))));  
        	double y = Double.parseDouble(df.format((CIRCLE_CENTER_Y + CIRCLE_R * Math.cos(Math.PI * (ANGLE * i) / 180)))); 
            points.add(new Point(x, y));  
        } 
        return points;
   }
	
//	public static void main(String[] args) {
//		List<Point> points = initPointsCircular(150, 50, 60, 5);
//        for (int i = 0; i < points.size(); i++) {
//        	Point pornt = (Point) points.get(i);
//            System.out.println("X =" + pornt.getX() + "Y =" + pornt.getY());
//        }
//    }
}