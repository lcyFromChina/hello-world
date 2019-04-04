package com.example.blocks;

import java.util.Random;
import java.lang.*;

import com.example.blocks.R.drawable;

import android.app.Activity;
import android.graphics.Paint.Join;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends Activity implements Runnable,OnClickListener{

	AbsoluteLayout abs;
	Handler handler=new Handler();
	static ImageView[][] imgs=new ImageView[15][10]; 
	static boolean[][] bools=new boolean[15][10];
	boolean judge=true;
  static int list;
  static int Y1,Y2,Y3,Y4;
  static int X1,X2,X3,X4;
  static int Ymax;
  static int Xmin;
  static int Xmax;
  static boolean jiwei0=true;
  static int jiwei1=1;
  static int jiwei2=1;
  static int jiwei3=1;
  static int jiwei4=1;
  static boolean running;
  static boolean maxall;
  static boolean allrunning=false;
  static boolean judge2=false;
  
  static int ymax1=0;
  static int ymax2=0;
  static int ymax3=0;
  static int ymax4=0;
  static int xmax1=0;
  static int xmax2=0;
  static int xmax3=0;
  static int xmax4=0;
	
	private Button btleft;
	private Button btright;
	private Button changebt;
	static private TextView tv1;
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity2);
		
		btleft=(Button) findViewById(R.id.leftbutton);
		btright=(Button) findViewById(R.id.rightbutton);
		changebt=(Button) findViewById(R.id.changebutton);
		tv1=(TextView) findViewById(R.id.tv1);
		btleft.setOnClickListener(this);
		btright.setOnClickListener(this);
		changebt.setOnClickListener(this);
		
		abs=(AbsoluteLayout) findViewById(R.id.abs);
		Activity2 act2=new Activity2();
		int x=0;
		int y=0;
		int id=1;
		for(int i=0;i<15;i++) {
			for(int j=0;j<10;j++) {
				imgs[i][j]=new ImageView(this);
				imgs[i][j].setX(x);
				imgs[i][j].setY(y);
				imgs[i][j].setId(id);
				id++;
				imgs[i][j].setBackgroundResource(R.drawable.white);
				bools[i][j]=false;
				x=x+60;
				
				abs.addView(imgs[i][j]);
				
				
			}
			x=0;y=y+60;
		}
		
		running=true;
		handler.post(act2);
		
	}
	/*
	 * （非 Javadoc）
	 * @see java.lang.Runnable#run()
	 * BUG说明，xmax，ymax归零访问越界
	 */
	public  void run() {
		
		if(allrunning) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			System.exit(0);
		}
		if(judge) {
			list=(int)(Math.random()*5);
			switch (list) {
		case 0:
			imgs[0][3].setBackgroundResource(R.drawable.red);//竖直
			imgs[0][4].setBackgroundResource(R.drawable.red);//旋转中心
			imgs[0][5].setBackgroundResource(R.drawable.red);
			imgs[0][6].setBackgroundResource(R.drawable.red);
			bools[0][3]=true;
			bools[0][4]=true;
			bools[0][5]=true;
			bools[0][6]=true;
			Y1=Y2=Y3=Y4=0;
			X1=3;X2=4;X3=5;X4=6;
			judge=false;
			xmax1=X1;xmax2=X2;xmax3=X3;xmax4=X4;
			ymax1=Y1;ymax2=Y2;ymax3=Y3;ymax4=Y4;
			break;
		case 1:
			imgs[1][5].setBackgroundResource(R.drawable.red);//中间
			imgs[0][4].setBackgroundResource(R.drawable.red);
			imgs[0][5].setBackgroundResource(R.drawable.red);//旋转中心
			imgs[0][6].setBackgroundResource(R.drawable.red);
			bools[1][5]=true;
			bools[0][4]=true;
			bools[0][5]=true;
			bools[0][6]=true;
			Y1=1;
			Y2=Y3=Y4=0;
			X1=5;X2=4;X3=5;X4=6;

			judge=false;
			xmax1=X1;xmax2=X2;xmax3=0;xmax4=X4;
			ymax1=Y1;ymax2=Y2;ymax3=-1;ymax4=Y4;
			break;
			
		case 2:
			
			imgs[0][4].setBackgroundResource(R.drawable.red);//z
			imgs[1][4].setBackgroundResource(R.drawable.red);
			imgs[1][5].setBackgroundResource(R.drawable.red);//旋转中心
			imgs[2][5].setBackgroundResource(R.drawable.red);
			bools[0][4]=true;
			bools[1][4]=true;
			bools[1][5]=true;
			bools[2][5]=true;
			Y1=0;Y2=Y3=1;Y4=2;
			X1=X2=4;X3=X4=5;
			judge=false;
			xmax1=0;xmax2=X2;xmax3=0;xmax4=X4;
			ymax1=-1;ymax2=Y2;ymax3=-1;ymax4=Y4;
			break;
			
		case 3:
			imgs[1][4].setBackgroundResource(R.drawable.red);//左
			imgs[0][4].setBackgroundResource(R.drawable.red);//旋转中心
			imgs[0][5].setBackgroundResource(R.drawable.red);
			imgs[0][6].setBackgroundResource(R.drawable.red);
			bools[1][4]=true;
			bools[0][4]=true;
			bools[0][5]=true;
			bools[0][6]=true;
			Y1=1;Y2=Y3=Y4=0;
			X1=X2=4;X3=5;X4=6;

			judge=false;
			xmax1=X1;xmax2=0;xmax3=X3;xmax4=X4;
			ymax1=Y1;ymax2=-1;ymax3=Y3;ymax4=Y4;
			break;
			
		case 4:
			imgs[0][3].setBackgroundResource(R.drawable.red);//右
			imgs[0][4].setBackgroundResource(R.drawable.red);
			imgs[0][5].setBackgroundResource(R.drawable.red);//旋转中心
			imgs[1][5].setBackgroundResource(R.drawable.red);
			bools[0][3]=true;
			bools[0][4]=true;
			bools[0][5]=true;
			bools[1][5]=true;
			Y1=Y2=Y3=0;Y4=1;
			X1=3;X2=4;X3=X4=5;

			judge=false;
			xmax1=X1;xmax2=X2;xmax3=0;xmax4=X4;
			ymax1=Y1;ymax2=Y2;ymax3=-1;ymax4=Y4;
			break;
		}
		}else {
			if(Y1>=Y2) {
				
				if(Y1>=Y3) {
					if(Y1>=Y4) {
						Ymax=Y1;
					}else {
						Ymax=Y4;
					}
				}else if(Y3>=Y4) {
					Ymax=Y3;
				}else {
					Ymax=Y4;
				}
				
			}else {
				
				if(Y2>=Y3) {
					if(Y2>=Y4) {
						Ymax=Y2;
					}else {
						Ymax=Y4;
					}
				}else if(Y3>=Y4) {
					Ymax=Y3;
				}else {
					Ymax=Y4;
				}
				
			}
				
				
				
				
			if(maxall){
				System.out.println("方块日志");
/*
 * 判断是否可以消除方块
 */
			int jk=0;	
		 for(int i=2;i<=14;i++) {
			 if(bools[i][0]||bools[i][1]||bools[i][2]||bools[i][3]||bools[i][4]||bools[i][5]||bools[i][6]||bools[i][7]||bools[i][8]||bools[i][9]) {
				 jk++;
			 }
		}	
		 if((jk==13)&&(bools[1][4]&&bools[1][5])) {
			 tv1.setText("GAMEOVER!!!!!");
			 allrunning=true;
		
		 }
				
				
	for(int i=0;i<=14;i++)	{		
		if(bools[i][0]&&bools[i][1]&&bools[i][2]&&bools[i][3]&&bools[i][4]&&bools[i][5]&&bools[i][6]&&bools[i][7]&&bools[i][8]&&bools[i][9]) {
			for(int j=0;j<=9;j++) {
				bools[i][j]=false;
				imgs[i][j].setBackgroundResource(R.drawable.white);
			}
			for(int k=i;k>0;k--) {
			for(int j=0;j<=9;j++) {
				bools[k][j]=bools[k-1][j];
				if(bools[k][j]) {
					imgs[k][j].setBackgroundResource(R.drawable.red);
				}else {
					imgs[k][j].setBackgroundResource(R.drawable.white);
				}
			}
			}
		}
	}
/*
 * 进行清零				
 */
				judge=true;
				jiwei0=true;
				jiwei1=1;
				jiwei2=1;
				jiwei3=1;
				jiwei4=1;
				judge2=false;
				
				maxall=false;
			}else if(Ymax<14) {//方块下降
				imgs[Y1][X1].setBackgroundResource(R.drawable.white);
				imgs[Y2][X2].setBackgroundResource(R.drawable.white);
				imgs[Y3][X3].setBackgroundResource(R.drawable.white);
				imgs[Y4][X4].setBackgroundResource(R.drawable.white);
				bools[Y1][X1]=false;
				bools[Y2][X2]=false;
				bools[Y3][X3]=false;
				bools[Y4][X4]=false;
				Y1++;Y2++;Y3++;Y4++;
				imgs[Y1][X1].setBackgroundResource(R.drawable.red);
				imgs[Y2][X2].setBackgroundResource(R.drawable.red);
				imgs[Y3][X3].setBackgroundResource(R.drawable.red);
				imgs[Y4][X4].setBackgroundResource(R.drawable.red);
				bools[Y1][X1]=true;
				bools[Y2][X2]=true;
				bools[Y3][X3]=true;
				bools[Y4][X4]=true;

/*
 * 获取方块位置。				
 */				
				switch(list) {
				case 0:
					if(jiwei0) {
						xmax1=X1;xmax2=X2;xmax3=X3;xmax4=X4;
						ymax1=Y1;ymax2=Y2;ymax3=Y3;ymax4=Y4;
					}else {
						xmax1=0;xmax2=0;xmax3=0;xmax4=X4;
						ymax1=-1;ymax2=-1;ymax3=-1;ymax4=Y4;
					}
					break;
				case 1:
					switch(jiwei1) {
						case 1:
							xmax1=X1;xmax2=X2;xmax3=0;xmax4=X4;
							ymax1=Y1;ymax2=Y2;ymax3=-1;ymax4=Y4;
							break;
						case 2:
							xmax1=X1;xmax2=0;xmax3=0;xmax4=X4;
							ymax1=Y1;ymax2=-1;ymax3=-1;ymax4=Y4;
							break;
						case 3:
							xmax1=0;xmax2=X2;xmax3=X3;xmax4=X4;
							ymax1=-1;ymax2=Y2;ymax3=Y3;ymax4=Y4;
							break;
						case 4:
							xmax1=X1;xmax2=X2;xmax3=0;xmax4=0;
							ymax1=Y1;ymax2=Y2;ymax3=-1;ymax4=-1;
							break;
					
					}
					break;
				case 2:
					switch (jiwei2) {
					case 1:
						xmax1=0;xmax2=X2;xmax3=0;xmax4=X4;
						ymax1=-1;ymax2=Y2;ymax3=-1;ymax4=Y4;
						break;
					case 2:
						xmax1=0;xmax2=0;xmax3=X3;xmax4=X4;
						ymax1=-1;ymax2=-1;ymax3=Y3;ymax4=Y4;
						break;
					case 3:
						xmax1=0;xmax2=X2;xmax3=X3;xmax4=X4;
						ymax1=-1;ymax2=Y2;ymax3=Y3;ymax4=Y4;
						break;
					case 4:
						xmax1=0;xmax2=X2;xmax3=X3;xmax4=X4;
						ymax1=-1;ymax2=Y2;ymax3=Y3;ymax4=Y4;
						break;
					}
					break;
				case 3:
					switch (jiwei3) {
					case 1:
						xmax1=X1;xmax2=0;xmax3=X3;xmax4=X4;
						ymax1=Y1;ymax2=-1;ymax3=Y3;ymax4=Y4;
						break;
					case 2:
						xmax1=X1;xmax2=0;xmax3=0;xmax4=X4;
						ymax1=Y1;ymax2=-1;ymax3=-1;ymax4=Y4;
						break;
					case 3:
						xmax1=0;xmax2=X2;xmax3=X3;xmax4=X4;
						ymax1=-1;ymax2=Y2;ymax3=Y3;ymax4=Y4;
						break;
					case 4:
						xmax1=X1;xmax2=X2;xmax3=0;xmax4=0;
						ymax1=Y1;ymax2=Y2;ymax3=-1;ymax4=-1;
						break;
					}
					break;
				case 4:
					switch (jiwei4) {
					case 1:
						xmax1=X1;xmax2=X2;xmax3=0;xmax4=X4;
						ymax1=Y1;ymax2=Y2;ymax3=-1;ymax4=Y4;
						break;
					case 2:
						xmax1=0;xmax2=0;xmax3=X3;xmax4=X4;
						ymax1=-1;ymax2=-1;ymax3=Y3;ymax4=Y4;
						break;
					case 3:
						xmax1=X1;xmax2=X2;xmax3=X3;xmax4=0;
						ymax1=Y1;ymax2=Y2;ymax3=Y3;ymax4=-1;
						break;
					case 4:
						xmax1=X1;xmax2=0;xmax3=0;xmax4=X4;
						ymax1=Y1;ymax2=-1;ymax3=-1;ymax4=Y4;
						break;
					}
					break;
			
				}
				
				if(Ymax+1==14) {
					maxall=true;
				}else {
					maxall=(bools[ymax1+1][xmax1]) ||(bools[ymax2+1][xmax2])||(bools[ymax3+1][xmax3])||(bools[ymax4+1][xmax4]);
				}
				
			}
			
			
			
			
			
			
		}
		judge2=true;
		
		if(running) {
			handler.postDelayed(this,1000);
		}
	}

	
	
	
	@Override
	public synchronized void onClick(View v) {
		if(Ymax!=14) {switch (v.getId()) {
		case R.id.leftbutton:
if(X1<=X2) {
				
				if(X1<=X3) {
					if(X1<=X4) {
						Xmin=X1;
					}else {
						Xmin=X4;
					}
				}else if(X3<=X4) {
					Xmin=X3;
				}else {
					Xmin=X4;
				}
				
			}else {
				
				if(X2<=X3) {
					if(X2<=X4) {
						Xmin=X2;
					}else {
						Xmin=X4;
					}
				}else if(X3<=X4) {
					Xmin=X3;
				}else {
					Xmin=X4;
				}
				
			}
			if(Xmin>0) {
			imgs[Y1][X1].setBackgroundResource(R.drawable.white);
			imgs[Y2][X2].setBackgroundResource(R.drawable.white);
			imgs[Y3][X3].setBackgroundResource(R.drawable.white);
			imgs[Y4][X4].setBackgroundResource(R.drawable.white);
			bools[Y1][X1]=false;
			bools[Y2][X2]=false;
			bools[Y3][X3]=false;
			bools[Y4][X4]=false;
			if(!(bools[Y1][X1-1]||bools[Y2][X2-1]||bools[Y3][X3-1]||bools[Y4][X4-1])) {
				//if(!((ymax1+1==15)||(ymax2+1==15)||(ymax3+1==15)||(ymax4+1==15))) {
				//if(!((bools[ymax1+1][xmax1]) ||(bools[ymax2+1][xmax2])||(bools[ymax3+1][xmax3])||(bools[ymax4+1][xmax4]))) {
							if(judge2) {	
					X1--;X2--;X3--;X4--;
					
					if(ymax1!=-1) {
						xmax1--;
					}
					if(ymax2!=-1) {
						xmax2--;
					}
					if(ymax3!=-1) {
						xmax3--;
					}
					if(ymax4!=-1) {
						xmax4--;
					}
					if(Ymax+1==14) {
						maxall=true;
					}else {
						maxall=(bools[ymax1+1][xmax1]) ||(bools[ymax2+1][xmax2])||(bools[ymax3+1][xmax3])||(bools[ymax4+1][xmax4]);
						//}
					//}
				}
				}	
			}
			
			imgs[Y1][X1].setBackgroundResource(R.drawable.red);
			imgs[Y2][X2].setBackgroundResource(R.drawable.red);
			imgs[Y3][X3].setBackgroundResource(R.drawable.red);
			imgs[Y4][X4].setBackgroundResource(R.drawable.red);
			bools[Y1][X1]=true;
			bools[Y2][X2]=true;
			bools[Y3][X3]=true;
			bools[Y4][X4]=true;
			
			
			
			
			}
				
			
			break;

		case R.id.rightbutton:

if(X1>=X2) {
				
				if(X1>=X3) {
					if(X1>=X4) {
						Xmax=X1;
					}else {
						Xmax=X4;
					}
				}else if(X3>=X4) {
					Xmax=X3;
				}else {
					Xmax=X4;
				}
				
			}else {
				
				if(X2>=X3) {
					if(Y2>=X4) {
						Xmax=X2;
					}else {
						Xmax=X4;
					}
				}else if(X3>=X4) {
					Xmax=X3;
				}else {
					Xmax=X4;
				}
				
			}

			if(Xmax<9) {
				imgs[Y1][X1].setBackgroundResource(R.drawable.white);
				imgs[Y2][X2].setBackgroundResource(R.drawable.white);
				imgs[Y3][X3].setBackgroundResource(R.drawable.white);
				imgs[Y4][X4].setBackgroundResource(R.drawable.white);
				bools[Y1][X1]=false;
				bools[Y2][X2]=false;
				bools[Y3][X3]=false;
				bools[Y4][X4]=false;
				if(!(bools[Y1][X1+1]||bools[Y2][X2+1]||bools[Y3][X3+1]||bools[Y4][X4+1])) {
					//if(!((ymax1+1==15)||(ymax2+1==15)||(ymax3+1==15)||(ymax4+1==15))) {
					//if(!((bools[ymax1+1][xmax1]) ||(bools[ymax2+1][xmax2])||(bools[ymax3+1][xmax3])||(bools[ymax4+1][xmax4]))) {
					if(judge2) {
						X1++;X2++;X3++;X4++;
						if(ymax1!=-1) {
							xmax1++;
						}
						if(ymax2!=-1) {
							xmax2++;
						}
						if(ymax3!=-1) {
							xmax3++;
						}
						if(ymax4!=-1) {
							xmax4++;
						}
						if(Ymax+1==14) {
							maxall=true;
						}else {
							maxall=(bools[ymax1+1][xmax1]) ||(bools[ymax2+1][xmax2])||(bools[ymax3+1][xmax3])||(bools[ymax4+1][xmax4]);
							}
						}
						
					//}
					//}
				}
				
				imgs[Y1][X1].setBackgroundResource(R.drawable.red);
				imgs[Y2][X2].setBackgroundResource(R.drawable.red);
				imgs[Y3][X3].setBackgroundResource(R.drawable.red);
				imgs[Y4][X4].setBackgroundResource(R.drawable.red);
				bools[Y1][X1]=true;
				bools[Y2][X2]=true;
				bools[Y3][X3]=true;
				bools[Y4][X4]=true;

				
				
				
	}
				
			
			

			break;
		case R.id.changebutton:
				
				if(list==0) {
				if(jiwei0) {
					imgs[Y1][X1].setBackgroundResource(R.drawable.white);
					imgs[Y3][X3].setBackgroundResource(R.drawable.white);
					imgs[Y4][X4].setBackgroundResource(R.drawable.white);
					bools[Y1][X1]=false;
					bools[Y3][X3]=false;
					bools[Y4][X4]=false;
					
					if(Y1-1>=0) {
						if(Y3+1<=14) {
							if(Y4+2<=14) {
								if(X2<=14) {
									if(X2>=0) {
										if(!(bools[Y1-1][X2]||bools[Y3+1][X2]||bools[Y4+2][X2])) {
											if(!((ymax1+1==15)||(ymax2+1==15)||(ymax3+1==15)||(ymax4+1==15))) {
											if(!((bools[ymax1+1][xmax1]) ||(bools[ymax2+1][xmax2])||(bools[ymax3+1][xmax3])||(bools[ymax4+1][xmax4]))) {
										X1=X2;Y1--;
										X3=X2;Y3++;
										X4=X2;Y4=Y4+2;
										jiwei0=!jiwei0;
											}
											}
										}
									}
								}
							}
						}
					}
					imgs[Y1][X1].setBackgroundResource(R.drawable.red);
					imgs[Y3][X3].setBackgroundResource(R.drawable.red);
					imgs[Y4][X4].setBackgroundResource(R.drawable.red);
					bools[Y1][X1]=true;
					bools[Y3][X3]=true;
					bools[Y4][X4]=true;

							
				}else {
					imgs[Y1][X1].setBackgroundResource(R.drawable.white);
					imgs[Y3][X3].setBackgroundResource(R.drawable.white);
					imgs[Y4][X4].setBackgroundResource(R.drawable.white);
					bools[Y1][X1]=false;
					bools[Y3][X3]=false;
					bools[Y4][X4]=false;
					
					
					if(X1-1>=0) {
						if(Y1+1<=14) {
							if(X3+1<=9) {
								if(Y3-1>=0) {
									if(X4+2<=9) {
										if(Y4-2>=0) {
											if(!(bools[Y1+1][X1-1]||bools[Y3-1][X3+1]||bools[Y4-2][X4+2])) {
												if(!((ymax1+1==15)||(ymax2+1==15)||(ymax3+1==15)||(ymax4+1==15))) {
												if(!((bools[ymax1+1][xmax1]) ||(bools[ymax2+1][xmax2])||(bools[ymax3+1][xmax3])||(bools[ymax4+1][xmax4]))) {
											X1=X1-1;Y1++;
											X3=X3+1;Y3--;
											X4=X4+2;Y4=Y4-2;
											jiwei0=!jiwei0;
												}
												}
											}
										}
									}
								}
							}
						}
					}
					imgs[Y1][X1].setBackgroundResource(R.drawable.red);
					imgs[Y3][X3].setBackgroundResource(R.drawable.red);
					imgs[Y4][X4].setBackgroundResource(R.drawable.red);
					bools[Y1][X1]=true;
					bools[Y3][X3]=true;
					bools[Y4][X4]=true;

				}
				
				
			}else if(list==1) {
				if(jiwei1==1) {
					imgs[Y1][X1].setBackgroundResource(R.drawable.white);
					imgs[Y2][X2].setBackgroundResource(R.drawable.white);
					imgs[Y4][X4].setBackgroundResource(R.drawable.white);
					bools[Y1][X1]=false;
					bools[Y2][X2]=false;
					bools[Y4][X4]=false;
					if(X1-1>=0) {
						if(Y1-1>=0) {
							if(X2+1<=9) {
								if(Y2-1>=0) {
									if(X4-1>=0) {
										if(Y4+1<=14) {
											if(!(bools[Y1-1][X1-1]||bools[Y2-1][X2+1]||bools[Y4+1][X4-1])) {
												if(!((ymax1+1==15)||(ymax2+1==15)||(ymax3+1==15)||(ymax4+1==15))) {
												if(!((bools[ymax1+1][xmax1]) ||(bools[ymax2+1][xmax2])||(bools[ymax3+1][xmax3])||(bools[ymax4+1][xmax4]))) {
											X1--;Y1--;
											X2++;Y2--;
											X4--;Y4++;	
											jiwei1++;	
												}
											
												}
											}
										}
									}
								}				
							}
						}
					}
					imgs[Y1][X1].setBackgroundResource(R.drawable.red);
					imgs[Y2][X2].setBackgroundResource(R.drawable.red);
					imgs[Y4][X4].setBackgroundResource(R.drawable.red);
					bools[Y1][X1]=true;
					bools[Y2][X2]=true;
					bools[Y4][X4]=true;

					
				}else if(jiwei1==2) {
					imgs[Y1][X1].setBackgroundResource(R.drawable.white);
					imgs[Y2][X2].setBackgroundResource(R.drawable.white);
					imgs[Y4][X4].setBackgroundResource(R.drawable.white);
					bools[Y1][X1]=false;
					bools[Y2][X2]=false;
					bools[Y4][X4]=false;
					
					if(X1+1<=9) {
						if(Y1-1>=0) {
							if(X2+1<=9) {
								if(Y2+1<=14) {
									if(X4-1>=0) {
										if(Y4-1>=0) {
											if(!(bools[Y1-1][X1+1]||bools[Y2+1][X2+1]||bools[Y4-1][X4-1])) {
												if(!((ymax1+1==15)||(ymax2+1==15)||(ymax3+1==15)||(ymax4+1==15))) {
												if(!((bools[ymax1+1][xmax1]) ||(bools[ymax2+1][xmax2])||(bools[ymax3+1][xmax3])||(bools[ymax4+1][xmax4]))) {
											X1++;Y1--;
											X2++;Y2++;
											X4--;Y4--;	
											jiwei1++;		
												}
												
												}
											}
										}
									}
								}				
							}
						}
					}
					imgs[Y1][X1].setBackgroundResource(R.drawable.red);
					imgs[Y2][X2].setBackgroundResource(R.drawable.red);
					imgs[Y4][X4].setBackgroundResource(R.drawable.red);
					bools[Y1][X1]=true;
					bools[Y2][X2]=true;
					bools[Y4][X4]=true;
					

				}else if(jiwei1==3) {
					imgs[Y1][X1].setBackgroundResource(R.drawable.white);
					imgs[Y2][X2].setBackgroundResource(R.drawable.white);
					imgs[Y4][X4].setBackgroundResource(R.drawable.white);
					bools[Y1][X1]=false;
					bools[Y2][X2]=false;
					bools[Y4][X4]=false;
					
					if(X1+1<=9) {
						if(Y1+1<=14) {
							if(X2-1>=0) {
								if(Y2+1<=14) {
									if(X4+1<=9) {
										if(Y4-1>=0) {
											if(!(bools[Y1+1][X1+1]||bools[Y2+1][X2-1]||bools[Y4-1][X4+1])) {
												if(!((ymax1+1==15)||(ymax2+1==15)||(ymax3+1==15)||(ymax4+1==15))) {
												if(!((bools[ymax1+1][xmax1]) ||(bools[ymax2+1][xmax2])||(bools[ymax3+1][xmax3])||(bools[ymax4+1][xmax4]))) {
											X1++;Y1++;
											X2--;Y2++;
											X4++;Y4--;	
											jiwei1++;			
												}
												}
												
										}
											
										}
									}
								}				
							}
						}
					}
					imgs[Y1][X1].setBackgroundResource(R.drawable.red);
					imgs[Y2][X2].setBackgroundResource(R.drawable.red);
					imgs[Y4][X4].setBackgroundResource(R.drawable.red);
					bools[Y1][X1]=true;
					bools[Y2][X2]=true;
					bools[Y4][X4]=true;
					

				}else if(jiwei1==4) {
					imgs[Y1][X1].setBackgroundResource(R.drawable.white);
					imgs[Y2][X2].setBackgroundResource(R.drawable.white);
					imgs[Y4][X4].setBackgroundResource(R.drawable.white);
					bools[Y1][X1]=false;
					bools[Y2][X2]=false;
					bools[Y4][X4]=false;
					if(X1-1>=0) {
						if(Y1+1<=14) {
							if(X2-1>=0) {
								if(Y2-1>=0) {
									if(X4+1<=9) {
										if(Y4+1<=14) {
											if(!(bools[Y1+1][X1-1]||bools[Y2-1][X2-1]||bools[Y4+1][X4+1])) {
												if(!((ymax1+1==15)||(ymax2+1==15)||(ymax3+1==15)||(ymax4+1==15))) {
												if(!((bools[ymax1+1][xmax1]) ||(bools[ymax2+1][xmax2])||(bools[ymax3+1][xmax3])||(bools[ymax4+1][xmax4]))) {
											X1--;Y1++;
											X2--;Y2--;
											X4++;Y4++;
											jiwei1=1;		
												}
												
												}
										}
											
										}
									}
								}				
							}
						}
					}
					imgs[Y1][X1].setBackgroundResource(R.drawable.red);
					imgs[Y2][X2].setBackgroundResource(R.drawable.red);
					imgs[Y4][X4].setBackgroundResource(R.drawable.red);
					bools[Y1][X1]=true;
					bools[Y2][X2]=true;
					bools[Y4][X4]=true;

				}
				
			}else if(list==2) {
				if(jiwei2==1) {
					imgs[Y1][X1].setBackgroundResource(R.drawable.white);
					imgs[Y4][X4].setBackgroundResource(R.drawable.white);
					bools[Y1][X1]=false;
					bools[Y4][X4]=false;
					if(X1+1<=9) {
						if(X4-1>=0) {
							if(!(bools[Y1][X1+1]||bools[Y4][X4-1])) {
								if(!((ymax1+1==15)||(ymax2+1==15)||(ymax3+1==15)||(ymax4+1==15))) {
								if(!((bools[ymax1+1][xmax1]) ||(bools[ymax2+1][xmax2])||(bools[ymax3+1][xmax3])||(bools[ymax4+1][xmax4]))) {
							X1++;
							X4--;
							jiwei2++;		
								}
								}
								
						}
							
						}
					}
					imgs[Y1][X1].setBackgroundResource(R.drawable.red);
					imgs[Y4][X4].setBackgroundResource(R.drawable.red);
					bools[Y1][X1]=true;
					bools[Y4][X4]=true;

					
				}else if(jiwei2==2) {
					imgs[Y4][X4].setBackgroundResource(R.drawable.white);
					bools[Y4][X4]=false;
					if(X4+2<=9) {
						if(Y4-2>=0) {
							if(!(bools[Y4-2][X4-2])) {
								if(!((ymax1+1==15)||(ymax2+1==15)||(ymax3+1==15)||(ymax4+1==15))) {
								if(!((bools[ymax1+1][xmax1]) ||(bools[ymax2+1][xmax2])||(bools[ymax3+1][xmax3])||(bools[ymax4+1][xmax4]))) {
							X4=X4+2;
							Y4=Y4-2;
							jiwei2++;			
								}
								}
								
						}
							
						}
					}
					
					imgs[Y4][X4].setBackgroundResource(R.drawable.red);
					bools[Y4][X4]=true;

				}else if(jiwei2==3) {
					imgs[Y2][X2].setBackgroundResource(R.drawable.white);
					imgs[Y4][X4].setBackgroundResource(R.drawable.white);
					bools[Y2][X2]=false;
					bools[Y4][X4]=false;
					if(Y2-1>=0) {
						if(Y4+1<=14) {
							if(!(bools[Y2-1][X2]||bools[Y4+1][X4])) {
								if(!((ymax1+1==15)||(ymax2+1==15)||(ymax3+1==15)||(ymax4+1==15))) {
								if(!((bools[ymax1+1][xmax1]) ||(bools[ymax2+1][xmax2])||(bools[ymax3+1][xmax3])||(bools[ymax4+1][xmax4]))) {
							Y2--;
							Y4++;
							jiwei2++;			
								}
							
								}
						}
							
						}
					}
					imgs[Y2][X2].setBackgroundResource(R.drawable.red);
					imgs[Y4][X4].setBackgroundResource(R.drawable.red);
					bools[Y2][X2]=true;
					bools[Y4][X4]=true;

				}else if(jiwei2==4) {
					imgs[Y1][X1].setBackgroundResource(R.drawable.white);
					imgs[Y2][X2].setBackgroundResource(R.drawable.white);
					imgs[Y4][X4].setBackgroundResource(R.drawable.white);
					bools[Y1][X1]=false;
					bools[Y2][X2]=false;
					bools[Y4][X4]=false;
					if(X1-1>=0) {
						if(Y2+1<=14) {
							if(X4-1>=0) {
								if(Y4+1<=14) {
									if(!(bools[Y1][X1-1]||bools[Y2+1][X2]||bools[Y4+1][X4-1])) {
										if(!((ymax1+1==15)||(ymax2+1==15)||(ymax3+1==15)||(ymax4+1==15))) {
										if(!((bools[ymax1+1][xmax1]) ||(bools[ymax2+1][xmax2])||(bools[ymax3+1][xmax3])||(bools[ymax4+1][xmax4]))) {
									X1--;
									Y2++;
									X4--;Y4++;
									jiwei2=1;			
										
										}
									}
									}
								}
								
							}
							
						}
						
					}
					imgs[Y1][X1].setBackgroundResource(R.drawable.red);
					imgs[Y2][X2].setBackgroundResource(R.drawable.red);
					imgs[Y4][X4].setBackgroundResource(R.drawable.red);
					bools[Y1][X1]=true;
					bools[Y2][X2]=true;
					bools[Y4][X4]=true;

				}
				
			}else if(list==3) {
				if(jiwei3==1) {
					imgs[Y1][X1].setBackgroundResource(R.drawable.white);
					imgs[Y3][X3].setBackgroundResource(R.drawable.white);
					imgs[Y4][X4].setBackgroundResource(R.drawable.white);
					bools[Y1][X1]=false;
					bools[Y3][X3]=false;
					bools[Y4][X4]=false;
					if(X1-1>=0) {
						if(Y1-1>=0) {
							if(X3-1>=0) {
								if(Y3+1<=14) {
									if(X4-2>=0) {
										if(Y4+2<=14) {
											if(!(bools[Y1-1][X1-1]||bools[Y3+1][X3-1]||bools[Y4+2][X4-2])) {
												if(!((ymax1+1==15)||(ymax2+1==15)||(ymax3+1==15)||(ymax4+1==15))) {
												if(!((bools[ymax1+1][xmax1]) ||(bools[ymax2+1][xmax2])||(bools[ymax3+1][xmax3])||(bools[ymax4+1][xmax4]))) {
											X1--;Y1--;
											X3--;Y3++;
											X4=X4-2;Y4=Y4+2;
											jiwei3++;	
											
													}	
												}
											}
										}
									}
								}
							}
						}
					}
					imgs[Y1][X1].setBackgroundResource(R.drawable.red);
					imgs[Y3][X4].setBackgroundResource(R.drawable.red);
					imgs[Y4][X4].setBackgroundResource(R.drawable.red);
					bools[Y1][X1]=true;
					bools[Y3][X3]=true;
					bools[Y4][X4]=true;
					

				}else if(jiwei3==2) {
					imgs[Y1][X1].setBackgroundResource(R.drawable.white);
					imgs[Y3][X3].setBackgroundResource(R.drawable.white);
					imgs[Y4][X4].setBackgroundResource(R.drawable.white);
					bools[Y1][X1]=false;
					bools[Y3][X3]=false;
					bools[Y4][X4]=false;
					if(X1+1<=9) {
						if(Y1-1>=0) {
							if(X3-1>=0) {
								if(Y3-1>=0) {
									if(X4-2>=0) {
										if(Y4-2>=0) {
											if(!(bools[Y1-1][X1+1]||bools[Y3-1][X3-1]||bools[Y4-2][X4-2])) {
												if(!((ymax1+1==15)||(ymax2+1==15)||(ymax3+1==15)||(ymax4+1==15))) {
												if(!((bools[ymax1+1][xmax1]) ||(bools[ymax2+1][xmax2])||(bools[ymax3+1][xmax3])||(bools[ymax4+1][xmax4]))) {
											X1++;Y1--;
											X3--;Y3--;
											X4=X4-2;Y4=Y4-2;
											jiwei3++;	
												}
												}
											}
										}
									}
								}
							}
						}
					}
					
					imgs[Y1][X1].setBackgroundResource(R.drawable.red);
					imgs[Y3][X3].setBackgroundResource(R.drawable.red);
					imgs[Y4][X4].setBackgroundResource(R.drawable.red);
					bools[Y1][X1]=true;
					bools[Y3][X3]=true;
					bools[Y4][X4]=true;

					
				}else if(jiwei3==3) {
					imgs[Y1][X1].setBackgroundResource(R.drawable.white);
					imgs[Y3][X3].setBackgroundResource(R.drawable.white);
					imgs[Y4][X4].setBackgroundResource(R.drawable.white);
					bools[Y1][X1]=false;
					bools[Y3][X3]=false;
					bools[Y4][X4]=false;
					if(X1-1>=0) {
						if(Y1+1<=14) {
							if(X3+1<=9) {
								if(Y3-1>=0) {
									if(X4+2<=9) {
										if(Y4-2>=0) {
											if(!(bools[Y1+1][X1+1]||bools[Y3-1][X3+1]||bools[Y4-2][X4+2])) {
												if(!((ymax1+1==15)||(ymax2+1==15)||(ymax3+1==15)||(ymax4+1==15))) {
												if(!((bools[ymax1+1][xmax1]) ||(bools[ymax2+1][xmax2])||(bools[ymax3+1][xmax3])||(bools[ymax4+1][xmax4]))) {
											X1++;Y1++;
											X3++;Y3--;
											X4=X4+2;Y4=Y4-2;
											jiwei3++;
													}
												}
											}
										}
									}
								}
							}
						}
					}
					
					imgs[Y1][X1].setBackgroundResource(R.drawable.red);
					imgs[Y3][X3].setBackgroundResource(R.drawable.red);
					imgs[Y4][X4].setBackgroundResource(R.drawable.red);
					bools[Y1][X1]=true;
					bools[Y3][X3]=true;
					bools[Y4][X4]=true;

				}else if(jiwei3==4) {
					imgs[Y1][X1].setBackgroundResource(R.drawable.white);
					imgs[Y3][X3].setBackgroundResource(R.drawable.white);
					imgs[Y4][X4].setBackgroundResource(R.drawable.white);
					bools[Y1][X1]=false;
					bools[Y3][X3]=false;
					bools[Y4][X4]=false;
					if(X1-1>=0) {
						if(Y1+1<=14) {
							if(X3+1<=9) {
								if(Y3+1<=14) {
									if(X4+2<=9) {
										if(Y4+2<=14) {
											if(!(bools[Y1+1][X1-1]||bools[Y3+1][X3+1]||bools[Y4+2][X4+2])) {
												if(!((ymax1+1==15)||(ymax2+1==15)||(ymax3+1==15)||(ymax4+1==15))) {
												if(!((bools[ymax1+1][xmax1]) ||(bools[ymax2+1][xmax2])||(bools[ymax3+1][xmax3])||(bools[ymax4+1][xmax4]))) {
											X1--;Y1++;
											X3++;Y3++;
											X4=X4+2;Y4=Y4+2;
											jiwei3=1;	
												}	
												}
											}
										}
									}
								}
							}
						}
					}
					
					imgs[Y1][X1].setBackgroundResource(R.drawable.red);
					imgs[Y3][X3].setBackgroundResource(R.drawable.red);
					imgs[Y4][X4].setBackgroundResource(R.drawable.red);
					bools[Y1][X1]=true;
					bools[Y3][X3]=true;
					bools[Y4][X4]=true;

				}
				
			}else if(list==4) {
				if(jiwei4==1) {
					imgs[Y1][X1].setBackgroundResource(R.drawable.white);
					imgs[Y2][X2].setBackgroundResource(R.drawable.white);
					imgs[Y4][X4].setBackgroundResource(R.drawable.white);
					bools[Y1][X1]=false;
					bools[Y2][X2]=false;
					bools[Y4][X4]=false;
					if(X1+2<=9) {
						if(Y1-2>=0) {
							if(X2+1<=9) {
								if(Y2-1>=0) {
									if(X4-1>=0) {
										if(Y4-1>=0) {
											if(!(bools[Y1-2][X1+2]||bools[Y2-1][X2+1]||bools[Y4-1][X4-1])) {
												if(!((ymax1+1==15)||(ymax2+1==15)||(ymax3+1==15)||(ymax4+1==15))) {
												if(!((bools[ymax1+1][xmax1]) ||(bools[ymax2+1][xmax2])||(bools[ymax3+1][xmax3])||(bools[ymax4+1][xmax4]))) {
													
											X1=X1+2;Y1=Y1-2;
											X2++;Y2--;
											X4--;Y4--;
											jiwei4++;	
											//System.out.println("日志");
													}
												}
											}
										}
									}
								}
							}
						}
					}
					imgs[Y1][X1].setBackgroundResource(R.drawable.red);
					imgs[Y2][X2].setBackgroundResource(R.drawable.red);
					imgs[Y4][X4].setBackgroundResource(R.drawable.red);
					bools[Y1][X1]=true;
					bools[Y2][X2]=true;
					bools[Y4][X4]=true;
					

				}else if(jiwei4==2) {
					imgs[Y1][X1].setBackgroundResource(R.drawable.white);
					imgs[Y2][X2].setBackgroundResource(R.drawable.white);
					imgs[Y4][X4].setBackgroundResource(R.drawable.white);
					bools[Y1][X1]=false;
					bools[Y2][X2]=false;
					bools[Y4][X4]=false;
					
					if(X1+2<=9) {
						if(Y1+2<=14) {
							if(X2+1<=9) {
								if(Y2+1<=14) {
									if(X4+1<=9) {
										if(Y4-1>=0) {
											if(!(bools[Y1+2][X1+2]||bools[Y2+1][X2+1]||bools[Y4-1][X4+1])) {
												if(!((ymax1+1==15)||(ymax2+1==15)||(ymax3+1==15)||(ymax4+1==15))) {
												if(!((bools[ymax1+1][xmax1]) ||(bools[ymax2+1][xmax2])||(bools[ymax3+1][xmax3])||(bools[ymax4+1][xmax4]))) {
													
											X1=X1+2;Y1=Y1+2;
											X2++;Y2++;
											X4++;Y4--;	
											jiwei4++;
												}
											}	
											}
										}
									}
								}
							}
						}
					}
					imgs[Y1][X1].setBackgroundResource(R.drawable.red);
					imgs[Y2][X2].setBackgroundResource(R.drawable.red);
					imgs[Y4][X4].setBackgroundResource(R.drawable.red);
					bools[Y1][X1]=true;
					bools[Y2][X2]=true;
					bools[Y4][X4]=true;

					
				}else if(jiwei4==3) {
					imgs[Y1][X1].setBackgroundResource(R.drawable.white);
					imgs[Y2][X2].setBackgroundResource(R.drawable.white);
					imgs[Y4][X4].setBackgroundResource(R.drawable.white);
					bools[Y1][X1]=false;
					bools[Y2][X2]=false;
					bools[Y4][X4]=false;
					if(X1-2>=0) {
						if(Y1+2<=14) {
							if(X2-1>=0) {
								if(Y2+1<=14) {
									if(X4+1<=9) {
										if(Y4+1<=14) {
											if(!(bools[Y1+2][X1-2]||bools[Y2+1][X2-1]||bools[Y4+1][X4+1])) {
												if(!((ymax1+1==15)||(ymax2+1==15)||(ymax3+1==15)||(ymax4+1==15))) {
												if(!((bools[ymax1+1][xmax1]) ||(bools[ymax2+1][xmax2])||(bools[ymax3+1][xmax3])||(bools[ymax4+1][xmax4]))) {
											X1=X1-2;Y1=Y1+2;
											X2--;Y2++;
											X4++;Y4++;
											jiwei4++;		
												}
												}
									     	}	
								 		}
									}
								}
							}
						}
					}
					
					imgs[Y1][X1].setBackgroundResource(R.drawable.red);
					imgs[Y2][X2].setBackgroundResource(R.drawable.red);
					imgs[Y4][X4].setBackgroundResource(R.drawable.red);
					bools[Y1][X1]=true;
					bools[Y2][X2]=true;
					bools[Y4][X4]=true;

				}else if(jiwei4==4) {
					imgs[Y1][X1].setBackgroundResource(R.drawable.white);
					imgs[Y2][X2].setBackgroundResource(R.drawable.white);
					imgs[Y4][X4].setBackgroundResource(R.drawable.white);
					bools[Y1][X1]=false;
					bools[Y2][X2]=false;
					bools[Y4][X4]=false;
					
					
					if(X1-2>=0) {
						if(Y1-2>=0) {
							if(X2-1>=0) {
								if(Y2-1>=0) {
									if(X4-1>=0) {
										if(Y4+1<=14) {
											if(!(bools[Y1-2][X1-2]||bools[Y2-1][X2-1]||bools[Y4+1][X4-1])) {
												if(!((ymax1+1==15)||(ymax2+1==15)||(ymax3+1==15)||(ymax4+1==15))) {
												if(!((bools[ymax1+1][xmax1]) ||(bools[ymax2+1][xmax2])||(bools[ymax3+1][xmax3])||(bools[ymax4+1][xmax4]))) {
											X1=X1-2;Y1=Y1-2;
											X2--;Y2--;
											X4--;Y4++;
											jiwei4=1;	
												}
												}	
											}
										}
									}
								}
							}
						}
					}
						
					
					imgs[Y1][X1].setBackgroundResource(R.drawable.red);
					imgs[Y2][X2].setBackgroundResource(R.drawable.red);
					imgs[Y4][X4].setBackgroundResource(R.drawable.red);
					bools[Y1][X1]=true;
					bools[Y2][X2]=true;
					bools[Y4][X4]=true;

				}
			}
			
		
				
			
			break;
		}
		}		
	}
	public void onBackPressed() {
		print();
		allrunning=true;
	}
	public void print() {
		Toast.makeText(getApplicationContext(), "死按你的返回键退出", 5).show();
	}
}
