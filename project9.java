////Ryan Rosario
////Project-9

int many=5;
int alot=4;
Squid school[]=  new Squid[many];
String names[]=  { "Cali", "Mari", "Bloop", "Ward", "Tenta"};
float spacing;

float surface;
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
  for (int i=0; i<many; i++ ) {
    school[i]=  new Squid( names[i], x );
    x += spacing;
  }
}

 void draw() {
    scene();
    action();
    show();
   
 }
 

void scene() {
  background( 0,150,200 );      
  fill( 0,50,100 );
  noStroke();
  rect( 0,surface, width, height-surface );  
}

void action() {
  for (int i=0; i<many; i++ ) {
    school[i].move();
  }
}

void show() {
  float x=  spacing;
  for (int i=0; i<many; i++ ) {
    school[i].x=  x;
    x += spacing;
    school[i].show();
  }
}

   




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
   
   text(legs, x-10, y + 10);
   fill(r,g,b);
   stroke(r,g,b);
   ellipse(x,y, 40, 30);
   rect( x-40/2, y, 40, 30/2);
///legs
   stroke(r,g,b);
   strokeWeight(3);
   float legX = x-20;
   for (int i=0; i<legs; i++) {
     line(legX, y+20, legX-10, y+35);
     legX += 10;
   }
    strokeWeight(1);
    stroke(0);
}
}

  


     
   
