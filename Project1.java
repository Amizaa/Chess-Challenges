import java.util.*;

class CheckMoves extends Variable
{
 String[] ch = new String[100];
 String colorP,typeP,colorM;
 int xp , yp , xm ,ym;
 static int I=0;

 void Build()
 {
  for(int i=0 ; i<m ; i++)
  {
    xm = Integer.parseInt(position[i].substring(2, 3));
    ym = Integer.parseInt(position[i].substring(3));

    xp = Integer.parseInt(position[i].substring(0, 1));
    yp = Integer.parseInt(position[i].substring(1,2));
    String str = Loc[xp][yp];

    colorP = str.substring(0,1);
    typeP = str.substring(1);

    if(Loc[xm][ym]!=null)
    {
     String str1 = Loc[xm][ym];
     colorM = str1.substring(0,1);

     if(colorP.equals(colorM))
     {
       ch[I]="NO";
       I++;
       continue;
     }
    }
     
   Identify();
   I++;
  }
  for(int i=0 ; i<m ; i++)
   System.out.println(ch[i]);
 }

 void Identify()
 {
  if(typeP.equals("K"))
   ch[I]=King();
  if(typeP.equals("Q"))
   ch[I]=Queen();
  if(typeP.equals("B"))
   ch[I]=Bishop();
  if(typeP.equals("R"))
   ch[I]=Rook();
  if(typeP.equals("N"))
   ch[I]=Knight();
  if(typeP.equals("P"))
   ch[I]=Pawn();
 } 

 String Check()
 {
  if(Loc[xm][ym] == null)
  return "YES";

 else
   return "TAKE";
 }

 String King()
 {
  if( (xp-1==xm || xp==xm || xp+1==xm) && (yp-1==ym || yp==ym || yp+1==ym) )
   return Check();       

  else
   return "NO";
 }

 String Queen()
 {
  if(xp==xm || yp==ym)
   return Rook();

  int z = xp - xm;
  int k = yp - ym;

  if(z<0)
   z *= -1;
  if(k<0)
   k *= -1;

  if(z==k)
   return Bishop();
  
   return "NO";
 }

 String Bishop()
 {
  int z = xp - xm;
  int k = yp - ym;

  int Z=z , K=k;
  
  if(Z<0)
   Z *= -1;
  if(K<0)
   K *= -1;

  if(Z!=K)
   return "NO";

  if(z>0 && k>0)
  {
   for(int i=z-1 ; i>0 ; i--) 
   {
    if(Loc[xp-i][yp-i]!=null)
     return "NO";
   }
  }
  
  if(z>0 && k<0)
  {
   for(int i=z-1 ; i>0 ; i--) 
   {
    if(Loc[xp-i][yp+i]!=null)
     return "NO";
   }
  }

  if(z<0 && k>0)
  {
   for(int i=Z-1 ; i>0 ; i--) 
   {
    if(Loc[xp+i][yp-i]!=null)
     return "NO";
   }
  }

  if(z<0 && k<0)
  {
   for(int i=Z-1 ; i>0 ; i--) 
   {
    if(Loc[xp+i][yp+i]!=null)
     return "NO";
   }
  }

  return Check();
 }

 String Knight()
 {
   int z = xp - xm;
   int k = yp - ym;

  if(z<0)
   z *= -1;
  if(k<0)
   k *= -1;

  if( (z==1 && k==2) || (z==2 && k==1) )
   return Check();

  else 
   return "NO";
 }

 String Rook()
 {
  if(xp==xm)
  {
   if(yp-ym>0)
   {
    for(int i=yp-ym-1 ; i>0 ;i--)
    {
     if(Loc[xp][ym+i]!=null)
      return "NO";
    } 
   }

   if(yp-ym<0)
   {
    for(int i=ym-yp-1 ; i>0 ;i--)
    {
     if(Loc[xp][ym-i]!=null)
      return "NO";
    }     
   }

    return Check();
  }

  if(yp==ym)
  {
    if(xp-xm>0)
    {
     for(int i=xp-xm-1 ; i>0 ;i--)
     {
      if(Loc[xp-i][ym]!=null)
       return "NO";
     }
    }

    if(xp-xm<0)
    {
     for(int i=xm-xp-1 ; i>0 ;i--)
     {
      if(Loc[xp+i][ym]!=null)
       return "NO";
     }
    }

    return Check ();
   }
 
   return "NO";
 }

 String Pawn()
 {
  if(colorP.equals("W"))
  {
   if(xp-xm==2 && xp==6 && yp-ym==0)
   {
     if(Loc[xp-1][yp]==null && Loc[xm][ym]==null)
      return "YES";
    else
     return "NO";
   }

   if(xp-xm==1 && yp-ym==0)
   {
    if(Loc[xm][ym]==null)
     return "YES";
    else
     return "NO";
   }

   if(xp-xm==1 && (yp-ym==-1 || yp-ym==1))
   {
    if(Loc[xm][ym]!=null)
     return "TAKE";
    else
     return "NO";  
   }
  }

  else
  {
  if(xp-xm==-2 && xp==1 && yp-ym==0)
  {
   if(Loc[xp+1][yp]==null && Loc[xm][ym]==null)
    return "YES";
   else
    return "NO";
  }
   if(xp-xm==-1 && yp-ym==0)
    {
     if(Loc[xm][ym]==null)
      return "YES";
     else
      return "NO";
    }
 
    if(xp-xm==-1 && (yp-ym==-1 || yp-ym==1))
    {
     if(Loc[xm][ym]!=null)
      return "TAKE";
     else
      return "NO";  
    }
  }
  
  return "NO";
 }

}


class ChessBoard extends Variable
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

 final void PlaceOfPieces()
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

 void PlaceOfMovement()
 {
  for(int i=0 ; i<m ;i++)
  {
    String H1 = Motions[i].substring(3);
    int h1 = Integer.parseInt(H1);
    char s1 = Motions[i].charAt(2);
    int f1 = DefineNum(s1);
    
    String H2 = Motions[i].substring(1,2);
    int h2 = Integer.parseInt(H2);
    char s2 = Motions[i].charAt(0);
    int f2 = DefineNum(s2);
 
    position[i]="";
    position[i] += (8-h2);
    position[i] += f2;
    position[i] += (8-h1);
    position[i] += f1;
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

public class Project1 extends Variable
{
    public static void main(String[] args)
    {
     Scanner in = new Scanner(System.in);


     n = in.nextInt();
     in.nextLine(); 

     for(int i=0 ; i<n ; i++)
      Pieces[i] = in.nextLine();
     
     ChessBoard X = new ChessBoard();
     X.PlaceOfPieces();

     m = in.nextInt();
     in.nextLine();
     
     for(int i=0 ; i<m ; i++)
      Motions[i] = in.nextLine();
   
     X.PlaceOfMovement();
     
     CheckMoves Y = new CheckMoves();

     Y.Build();
     in.close();
    }
    
  }