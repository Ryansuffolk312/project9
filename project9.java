////Ryan Rosario
////CST-112
////Project-9

int many=5;
int alot=4;
Squid school[]=  new Squid[many];
Boat  fleet[]=   new Boat[alot];
String names[]=  { "Cali", "Mari", "Bloop", "Ward", "Tenta"};
String titles[]= {"RedL", "JackD", "RivR", "Spira"};

float spacing;
float ocean;
float surface;

String title= "CST112: Project 9";
String instr1= "Hold Shift and press any key to show list. Press 'r' to reset, 'q' to exit";
String instr2= "Press 'B' to sort x, 'D' to sort dx, and 'F' to sort Storage";
String instr3= "Press 'X' to sort x, 'Y' to sort y, 'S' to sort dy, and 'L' to sort Legs";
String author="Ryan Rosario";

float sunX=0, sunY=100, sunDX=2;

int score=0;

////Setup
void setup() {
  size( 800, 600 );
  spacing=  width/(many+1);
  reset();
}

void reset() {
  surface=  width/3;
  float x=  spacing;
  for (int i=0; i<many; i++ ) {school[i]= new Squid( names[i], x ); x += spacing;}  
  for (int i=0; i<alot; i++) {fleet[i]=   new Boat( titles[i], 100);}
}

///Handlers: Keys
void keyPressed() {
  if (key == 'X') {sortSquidX(school, school.length);}
  if (key == 'Y') {sortSquidY(school, school.length);}
  if (key == 'S') {sortSquidDY(school, school.length);}
  if (key == 'L') {sortSquidLegs(school, school.length);}
  if (key == 'B') {sortBoatX(fleet, fleet.length);}
  if (key == 'D') {sortBoatDX(fleet, fleet.length);}
  if (key == 'F') {sortBoatStorage(fleet, fleet.length);}
  if (key == 'r') {reset();}
  if (key == 'q') {exit();}
}

///Next Frames
 void draw() {
  scene();
  messages();
 if (key >= 'A' && key <= 'Z') {
    manifest(fleet, fleet.length);
    ecology( school, school.length);
    listInfo();
  }
  else 
  action();
  show();
  
 }
 
void scene() {
  background( 0,150,200 );      
  fill( 0,50,100 );
  noStroke();
  rect( 0,surface, width, height-surface );
  fill(#E8BE13);
  
  ellipse( sunX, sunY, 50, 50);
  sunX += sunDX;
  if(sunX>width) { sunX= 0;}
}

void action() {
  for (int i=0; i<many; i++ ) {school[i].move(); }
  for (int i=0; i<alot; i++) {fleet[i].move();}
}

void show() {
  float x=  spacing;
  for (int i=0; i<many; i++ ) {school[i].x= x; x += spacing; school[i].show();}
  for (int i=0; i<alot; i++ ) { fleet[i].show();}
}

///List arrays
void manifest(  Boat[] n, int alot ) {
  fill(#A7B9BC);
  rect( width/5, 65, 300, 110 );
  float x=190, y=100;
  // Labels.
  fill(150,0,0);
  text( "BOAT", x+20, y );
  text( "Storage", x+65, y );
  text( "x", x+115, y );
  text( "dx", x+205, y );
  fill(0);
  //
 for(int i=0; i<alot; i++){
  y += 15;
  //text( i, x, y );
  text( n[i].name, x+20, y );
  text( n[i].storage, x+70, y );
  text( n[i].x, x+100, y );
  text( n[i].dx, x+200, y );
 }
}
 void ecology( Squid[] w, int many) {
    fill(#A7B9BC);
  rect( width/5, 365, 330, 120 );
  float x=190, y=395;
  // Labels.
  fill(150,0,0);
  text( "Names", x+20, y );
  text( "Legs", x+65, y );
  text( "x", x+115, y );
  text( "y", x+165, y );
  text( "dy", x+225, y );
  fill(0);
  //
 for(int i=0; i<many; i++){
  y += 15;
 // text( i, x, y );
  text( w[i].name, x+20, y );
  text( w[i].legs, x+70, y );
  text( w[i].x, x+100, y );
  text( w[i].y, x+165, y );
  text( w[i].dy, x+225, y );
 }
}
 
 ///Sort Squid x coordinates
void sortSquidX( Squid[]a, int many ) {
  for( int m=many; m>1; m-- ) {
    int k=0;
    for( int j=1; j<m; j++) { 
          if (a[j].x > a[k].x) k=  j;
    }
    swapSquid( a, m-1, k);
  }
}
///Sort Y coordinates
void sortSquidY( Squid[]a, int many ) {
  for( int m=many; m>1; m-- ) {
    int k=0;
    for( int j=1; j<m; j++) { 
          if (a[j].y > a[k].y) k=  j;
    }
    swapSquid( a, m-1, k);
  }
}

void sortSquidLegs( Squid[]a, int many ) {
  for( int m=many; m>1; m-- ) {
    int k=0;
    for( int j=1; j<m; j++) { 
          if (a[j].legs > a[k].legs) k=  j;
    }
    swapSquid( a, m-1, k);
  }
}

void sortSquidDY( Squid[]a, int many ) {
  for( int m=many; m>1; m-- ) {
    int k=0;
    for( int j=1; j<m; j++) { 
          if (a[j].dy > a[k].dy) k=  j;
    }
    swapSquid( a, m-1, k);
  }
}

void swapSquid( Squid[] a, int j, int k ) {
 
  Squid t;
  t= a[k];
  a[k]= a[j];
  a[j]= t;
  
 
}

///Sort Boat x coordinates
void sortBoatX( Boat[]a, int many ) {
  for( int m=many; m>1; m-- ) {
    int k=0;
    for( int j=1; j<m; j++) { 
          if (a[j].x > a[k].x) k=  j;
    }
    swapBoat( a, m-1, k);
  }
}

void sortBoatStorage( Boat[]a, int many ) {
  for( int m=many; m>1; m-- ) {
    int k=0;
    for( int j=1; j<m; j++) { 
          if (a[j].storage > a[k].storage) k=  j;
    }
    swapBoat( a, m-1, k);
  }
}

void sortBoatDX( Boat[]a, int many ) {
  for( int m=many; m>1; m-- ) {
    int k=0;
    for( int j=1; j<m; j++) { 
          if (a[j].dx > a[k].dx) k=  j;
    }
    swapBoat( a, m-1, k);
  }
}

void swapBoat( Boat[] a, int j, int k ) {
  
  Boat t;
  t= a[k];
  a[k]= a[j];
  a[j]= t;
}

void messages(){
  textSize(20);
  fill(0);
  text(title, width/2.5, 20);
  textSize(14);
  text(instr1, width/4.5, 40);
  text(author, 20, height-20);
  //
  textSize(12);
}

void listInfo(){
  textSize(14);
  text(instr2, width/6, 195); 
  text(instr3, width/6, 355);
}


    



////Classes
class Squid {
  float x,y;
  float dx=0, dy=0; 
  float w=40, h=40;
  int legs=10; 
  String name= "";
  float r,g,b;
  int count=0;
///Constructors
 Squid( String s, float x) {
    this.name= s;
    this.x=x;
    bottom();
    ///
    r= int(random(100, 255));
    g= int(random(0, 100));
    b= int(random(100, 250));
 }
 ///
  void bottom(){
    y= height - h;
    dy= -random( 0.1, 0.9);
    legs= int( random(1,6));
  }
   void move() {
     count++;
     x += dx;
     y += dy;
     if (y>height) {bottom(); count++; }
     else if (y<surface) { dy= -3 * dy; }
   }

///display
 void show() {
   fill(r,g,b);
   stroke(r,g,b);
   ellipse(x,y, 40, 30);
   rect( x-40/2, y, 40, 30/2);
///legs
   stroke(r,g,b);
   strokeWeight(3);
   float legX = x-20;
   for (int i=0; i<legs; i++) {
   if(frameCount % 40 > 15) {line(legX, y+20, legX-10, y+35);}
   else                     {line(legX, y+20, legX+10, y+35);}
     legX += 10;
   }
    stroke(0);
    strokeWeight(3); 
    fill(200,200,0); 
    text( name, x-w/3, y-10+h/4 ); 
    fill(0); 
    text( legs, x+2-w/5, y+h/3 ); 
    fill(255); 
  } 
 boolean hit( float xx, float yy ) {return dist( xx,yy, x,y ) < h;}
}
  
  
class Boat {
  float x, y=surface;
  float dx, dy;
  int storage=0, hooked=0;
  String name= "";
  float r,g,b;
///Constructor   
  Boat( String f, float x) {
    this.name= f;
    this.x= x;
    ///
    r= int(random(0, 255));
    g= int(random(100, 100));
    b= int(random(100, 250));
    ///
    dx= random(1,4);
 }
 
  void move() {
   int hooked=0;
   for (int i=0; i<many; i++ ) {
   if (school[i].hit( x, surface )) {hooked += school[i].legs; school[i].bottom();}
    }
    storage += hooked;    
    x+=dx;
   if (x<0 || x>width) {dx *= -1;}
 }

 void show() {
    fill(r,g,b);
    rect( x, surface-20, 50, 20 ); 
    if (dx>0)   {triangle( x+50,surface, x+50,surface-20, x+70,surface-20 );} 
    else        {triangle( x,surface, x,surface-20, x-20,surface-20 );} 
    fill(#905E37);
    rect( x+12, surface-30, 5, 10 );       
    ///sails
    fill(255); 
    if (dx>0)   {rect( x-15, surface-40, 25, 10 );}
    else        {rect( x+20, surface-40, 25, 10);}
    fill(255); 
    strokeWeight(3);
    text( name, x+5, surface-10 ); 
    fill(0); 
    text( storage, x+30, surface); 
 }
}
  
   

   
   
  
  


     
   
