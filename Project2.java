import java.util.*;

class Count extends Variable
{
 String colorP,typeP;
 int xp , yp , X , Y;
 static int I=0;

 void Scan()
 {
  for(int i=0 ; i<m ; i++)
  {
    xp = Integer.parseInt(position[i].substring(0, 1));
    yp = Integer.parseInt(position[i].substring(1));
    String str = Loc[xp][yp];

    colorP = str.substring(0,1);
    typeP = str.substring(1);

   Identify();
   System.out.println(I);
   I=0;
  }

 }

 void Check()
 {
  if(Loc[X][Y] == null)
   I++;
  if(Loc[X][Y] != null && !colorP.equals(Loc[X][Y].substring(0, 1)) )
   I++;
 }

 void Identify()
 {
  if(typeP.equals("K"))
   King();
  if(typeP.equals("Q"))
   Queen();
  if(typeP.equals("B"))
   Bishop();
  if(typeP.equals("R"))
   Rook();
  if(typeP.equals("N"))
   Knight();
  if(typeP.equals("P"))
   Pawn();
 }

 void King()
 {
  for(int i=-1 ; i<=1 ; i++)
  {
   for(int j=-1 ; j<=1 ; j++)
   {
    X=xp+i;
    Y=yp+j;

    if(X>=0 && X<=7 && Y>=0 && Y<=7)
     Check();
   }
  }

 }

void Queen()
 {
  Rook();
  Bishop();
 }

 void Bishop()
 {
  for(int i=1 ; i<8 ; i++)
  {
   X = xp-i;
   Y = yp-i;
   if(X>=0 && X<=7 && Y>=0 && Y<=7)
   {
    if(Loc[X][Y]!=null)
    {
      Check();
      break;
    }
    Check();
   }
    
  }
  for(int i=1 ; i<8 ; i++)
  {
   X = xp-i;
   Y = yp+i;
   if(X>=0 && X<=7 && Y>=0 && Y<=7)
   {
    if(Loc[X][Y]!=null)
    {
      Check();
      break;
    }
    Check();
   }
  }

  for(int i=1 ; i<8 ; i++)
  {
   X = xp+i;
   Y = yp-i;
   if(X>=0 && X<=7 && Y>=0 && Y<=7)
   {
    if(Loc[X][Y]!=null)
    {
      Check();
      break;
    }
    Check();
   }
  }

  for(int i=1 ; i<8 ; i++)
  {
   X = xp+i;
   Y = yp+i;
   if(X>=0 && X<=7 && Y>=0 && Y<=7)
   {
    if(Loc[X][Y]!=null)
    {
      Check();
      break;
    }
    Check();
   }
  }
 
 }

 void Knight()
 {
   for(int i=-1 ; i<=1 ;)
   {
    X = xp+i;
    Y = yp-2;
    if(X>=0 && X<=7 && Y>=0 && Y<=7)
     Check();

    X = xp+i;
    Y = yp+2;
    if(X>=0 && X<=7 && Y>=0 && Y<=7)
     Check();

    X = xp-2;
    Y = yp+i;
    if(X>=0 && X<=7 && Y>=0 && Y<=7)
     Check();

    X = xp+2;
    Y = yp+i;
    if(X>=0 && X<=7 && Y>=0 && Y<=7)
     Check();
    
    i+=2;
   }

 }

 void Rook()
 {
  for(int i=1 ; i<8 ; i++)
  {
   X = xp;
   Y = yp+i;
   if(X>=0 && X<=7 && Y>=0 && Y<=7)
   {
    if(Loc[X][Y]!=null)
    {
      Check();
      break;
    }
    Check();
   }
  }

  for(int i=1 ; i<8 ; i++)
  {
   X = xp;
   Y = yp-i;
   if(X>=0 && X<=7 && Y>=0 && Y<=7)
   {
    if(Loc[X][Y]!=null)
    {
      Check();
      break;
    }
    Check();
   }
  }

  for(int i=1 ; i<8 ; i++)
  {
   X = xp+i;
   Y = yp;
   if(X>=0 && X<=7 && Y>=0 && Y<=7)
   {
    if(Loc[X][Y]!=null)
    {
      Check();
      break;
    }
    Check();
   }
  }

  for(int i=1 ; i<8 ; i++)
  {
   X = xp-i;
   Y = yp;
   if(X>=0 && X<=7 && Y>=0 && Y<=7)
   {
    if(Loc[X][Y]!=null)
    {
      Check();
      break;
    }
    Check();
   }
  }

 }

 void Pawn()
 {
  if(colorP.equals("W"))
  {
   if(xp==6)
    if(Loc[xp-1][yp]==null && Loc[xp-2][yp]==null)
     I++;

   for(int i=-1 ; i<=1 ;)
   {
    if(yp+i>=0 && yp+i<8 && xp-1>=0)
     if( Loc[xp-1][yp+i] != null && !colorP.equals(Loc[xp-1][yp+i].substring(0, 1)) )
      I++; 
    i+=2;
   }

   if(xp-1>=0 && Loc[xp-1][yp] == null )
    I++;  
  }

  else
  {
   if(xp==1)
    if(Loc[xp+1][yp]==null && Loc[xp+2][yp]==null)
     I++;

    for(int i=-1 ; i<=1 ;)
    {
     if(yp+i>=0 && yp+i<8 && xp+1<=7)
      if(Loc[xp+1][yp+i] != null && !colorP.equals(Loc[xp+1][yp+i].substring(0, 1)) )
       I++; 
    
    i+=2;
    } 
     
   if(xp+1<=7 && Loc[xp+1][yp] == null  )
    I++;   
  }
  
 }

}

class ChessBoard1 extends Variable
{ 
 int DefineNum(char s)
 {
   if(s == 'A')
    return 0;
   if(s == 'B')
    return 1;
   if(s == 'C')
    return 2;
   if(s == 'D')
    return 3;
   if(s == 'E')
    return 4;
   if(s == 'F')
    return 5;
   if(s == 'G')
    return 6;
   else
    return 7;
 }

 void PlaceOfPieces()
 {
  for(int i=0 ; i<n ; i++)
  {
    String H = Pieces[i].substring(3);
    int h = Integer.parseInt(H);
    char s = Pieces[i].charAt(2);
    int f = DefineNum(s);
 
    Loc[8-h][f] = Pieces[i].substring(0, 2);
  }

 }

 void PositionOfPieces()
 {
  for(int i=0 ; i<m ; i++)
  {
    String H = Motions[i].substring(1);
    int h = Integer.parseInt(H);
    char s = Motions[i].charAt(0);
    int f = DefineNum(s);
 
    position[i]="";
    position[i] += (8-h);
    position[i] += f;
  }
 }

}

abstract class Variable
{
  public static int m;
  public static int n;
  public static String[] Pieces = new String[100];
  public static String[] Motions = new String[100];
  public static String[][] Loc = new String[100][100];
  public static String[] position = new String[100];
}

class Project2 extends Variable
{
  public static void main(String[] args)
  {
      try (Scanner in = new Scanner(System.in)) {
          n = in.nextInt();
          in.nextLine();
          
          for(int i=0 ; i<n ; i++)
              Pieces[i] = in.nextLine();
          
          ChessBoard1 X = new ChessBoard1();
          X.PlaceOfPieces();
          
          m = in.nextInt();
          in.nextLine();
          
          for(int i=0 ; i<m ; i++)
              Motions[i] = in.nextLine();
          
          X.PositionOfPieces();
          
          Count Y = new Count();
          
          Y.Scan();
      }
    }
        
}