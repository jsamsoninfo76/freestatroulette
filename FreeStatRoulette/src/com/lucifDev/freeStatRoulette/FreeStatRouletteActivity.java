package com.lucifDev.freeStatRoulette;

import java.util.HashMap;
import java.util.LinkedList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.ads.AdRequest;
import com.google.ads.AdView;

public class FreeStatRouletteActivity extends Activity {
	/* ATTRIBUTS GLOBAUX */
	private HashMap<Integer, Integer> tabCoul;
	private TextView rouge,noir,pair,impair,col1,col2,col3,passe,manque,tiers,orphelin,voisinZero;

	private LinkedList<Integer> tabNum;
	private TextView affichage;
	private final int tailleTableau = 10;
	
	/* ATTRIBUTS: PREMIERE PARTIE DU TABLEAU */
	private TextView p12;
	
	/* ATTRIBUTS: PREMIERE PARTIE DU TABLEAU */
	private TextView m12;
	
	/* ATTRIBUTS: PREMIERE PARTIE DU TABLEAU */
	private TextView d12;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // Look up the AdView as a resource and load a request.
        AdView adView = (AdView)this.findViewById(R.id.adView);
        adView.loadAd(new AdRequest());
        
        /* Initialisation des Variables*/
        tabNum = new LinkedList<Integer>();
        
        /* Initialisation des différents tableaux */
        initCouleurCase();
        
        /* Initialisation des TextView */
        affichage =(TextView) findViewById(R.id.affichage);
        rouge  =(TextView) findViewById(R.id.rouge);
        rouge.setTextColor(Color.YELLOW);
        noir   =(TextView) findViewById(R.id.noir);
        noir.setTextColor(Color.YELLOW);
        passe  =(TextView) findViewById(R.id.passe);
        passe.setTextColor(Color.YELLOW);
        manque =(TextView) findViewById(R.id.manque);
        manque.setTextColor(Color.YELLOW);
        pair   =(TextView) findViewById(R.id.pair);
        pair.setTextColor(Color.YELLOW);
        impair =(TextView) findViewById(R.id.impair);
        impair.setTextColor(Color.YELLOW);
        p12    =(TextView) findViewById(R.id.p12);
        p12.setTextColor(Color.YELLOW);
        m12    =(TextView) findViewById(R.id.m12);
        m12.setTextColor(Color.YELLOW);
        d12    =(TextView) findViewById(R.id.d12);
        d12.setTextColor(Color.YELLOW);
        col1   =(TextView) findViewById(R.id.col1);
        col1.setTextColor(Color.YELLOW);
        col2   =(TextView) findViewById(R.id.col2);
        col2.setTextColor(Color.YELLOW);
        col3   =(TextView) findViewById(R.id.col3);
        col3.setTextColor(Color.YELLOW);
        tiers  =(TextView) findViewById(R.id.tiers);
        tiers.setTextColor(Color.YELLOW);
        orphelin  =(TextView) findViewById(R.id.orphelin);
        orphelin.setTextColor(Color.YELLOW);
        voisinZero=(TextView) findViewById(R.id.voisinZero);
        voisinZero.setTextColor(Color.YELLOW);
        
        /* Initialisation des Bouttons*/
        Button b0 = (Button) findViewById(R.id.button0);
        b0.setTextColor(Color.YELLOW);
        b0.setOnClickListener(new OnClickListener() {
		public void onClick(View v) { showDialog(0); } });
        
        Button b1 = (Button) findViewById(R.id.button1);
        b1.setTextColor(Color.RED);
        b1.setOnClickListener(new OnClickListener() {
    	public void onClick(View v) { showDialog(1); } });
        
        Button b2 = (Button) findViewById(R.id.button2);
        b2.setTextColor(Color.BLACK);
        b2.setOnClickListener(new OnClickListener() {
    	public void onClick(View v) { showDialog(2); } });
        
        Button b3 = (Button) findViewById(R.id.button3);
        b3.setTextColor(Color.RED);
        b3.setOnClickListener(new OnClickListener() {
    	public void onClick(View v) { showDialog(3); } });
        
        Button b4 = (Button) findViewById(R.id.button4);
        b4.setTextColor(Color.BLACK);
        b4.setOnClickListener(new OnClickListener() {
    	public void onClick(View v) { showDialog(4); } });
        
        Button b5 = (Button) findViewById(R.id.button5);
        b5.setTextColor(Color.RED);
        b5.setOnClickListener(new OnClickListener() {
    	public void onClick(View v) { showDialog(5); } });
        
        Button b6 = (Button) findViewById(R.id.button6);
        b6.setTextColor(Color.BLACK);
        b6.setOnClickListener(new OnClickListener() {
    	public void onClick(View v) { showDialog(6); } });
        
        Button b7 = (Button) findViewById(R.id.button7);
        b7.setTextColor(Color.RED);
        b7.setOnClickListener(new OnClickListener() {
    	public void onClick(View v) { showDialog(7); } });
        
        Button b8 = (Button) findViewById(R.id.button8);
        b8.setTextColor(Color.BLACK);
        b8.setOnClickListener(new OnClickListener() {
    	public void onClick(View v) { showDialog(8); } });
        
        Button b9 = (Button) findViewById(R.id.button9);
        b9.setTextColor(Color.RED);
        b9.setOnClickListener(new OnClickListener() {
    	public void onClick(View v) { showDialog(9); } });
        
        Button b10 = (Button) findViewById(R.id.button10);
        b10.setTextColor(Color.BLACK);
        b10.setOnClickListener(new OnClickListener() {
    	public void onClick(View v) { showDialog(10); } });
        
        Button b11 = (Button) findViewById(R.id.button11);
        b11.setTextColor(Color.BLACK);
        b11.setOnClickListener(new OnClickListener() {
    	public void onClick(View v) { showDialog(11); } });
        
        Button b12 = (Button) findViewById(R.id.button12);
        b12.setTextColor(Color.RED);
        b12.setOnClickListener(new OnClickListener() {
    	public void onClick(View v) { showDialog(12); } });
        
        Button b13 = (Button) findViewById(R.id.button13);
        b13.setTextColor(Color.BLACK);
        b13.setOnClickListener(new OnClickListener() {
    	public void onClick(View v) { showDialog(13); } });
        
        Button b14 = (Button) findViewById(R.id.button14);
        b14.setTextColor(Color.RED);
        b14.setOnClickListener(new OnClickListener() {
    	public void onClick(View v) { showDialog(14); } });
        
        Button b15 = (Button) findViewById(R.id.button15);
        b15.setTextColor(Color.BLACK);
        b15.setOnClickListener(new OnClickListener() {
    	public void onClick(View v) { showDialog(15); } });
        
        Button b16 = (Button) findViewById(R.id.button16);
        b16.setTextColor(Color.RED);
        b16.setOnClickListener(new OnClickListener() {
    	public void onClick(View v) { showDialog(16); } });
        
        Button b17 = (Button) findViewById(R.id.button17);
        b17.setTextColor(Color.BLACK);        
        b17.setOnClickListener(new OnClickListener() {
    	public void onClick(View v) { showDialog(17); } });
        
        Button b18 = (Button) findViewById(R.id.button18);
        b18.setTextColor(Color.RED);
        b18.setOnClickListener(new OnClickListener() {
    	public void onClick(View v) { showDialog(18); } });
        
        Button b19 = (Button) findViewById(R.id.button19);
        b19.setTextColor(Color.RED);
        b19.setOnClickListener(new OnClickListener() {
    	public void onClick(View v) { showDialog(19); } });
        
        Button b20 = (Button) findViewById(R.id.button20);
        b20.setTextColor(Color.BLACK);
        b20.setOnClickListener(new OnClickListener() {
    	public void onClick(View v) { showDialog(20); } });
        
        Button b21 = (Button) findViewById(R.id.button21);
        b21.setTextColor(Color.RED);
        b21.setOnClickListener(new OnClickListener() {
    	public void onClick(View v) { showDialog(21); } });
        
        Button b22 = (Button) findViewById(R.id.button22);
        b22.setTextColor(Color.BLACK);
        b22.setOnClickListener(new OnClickListener() {
    	public void onClick(View v) { showDialog(22); } });

        Button b23 = (Button) findViewById(R.id.button23);
        b23.setTextColor(Color.RED);
        b23.setOnClickListener(new OnClickListener() {
    	public void onClick(View v) { showDialog(23); } });

        Button b24 = (Button) findViewById(R.id.button24);
        b24.setTextColor(Color.BLACK);
        b24.setOnClickListener(new OnClickListener() {
    	public void onClick(View v) { showDialog(24); } });
        
        Button b25 = (Button) findViewById(R.id.button25);
        b25.setTextColor(Color.RED);
        b25.setOnClickListener(new OnClickListener() {
    	public void onClick(View v) { showDialog(25); } });
        
        Button b26 = (Button) findViewById(R.id.button26);
        b26.setTextColor(Color.BLACK);
        b26.setOnClickListener(new OnClickListener() {
    	public void onClick(View v) { showDialog(26); } });
        
        Button b27 = (Button) findViewById(R.id.button27);
        b27.setTextColor(Color.RED);
        b27.setOnClickListener(new OnClickListener() {
    	public void onClick(View v) { showDialog(27); } });
        
        Button b28 = (Button) findViewById(R.id.button28);
        b28.setTextColor(Color.BLACK);
        b28.setOnClickListener(new OnClickListener() {
    	public void onClick(View v) { showDialog(28); } });
        
        Button b29 = (Button) findViewById(R.id.button29);
        b29.setOnClickListener(new OnClickListener() {
    	public void onClick(View v) { showDialog(29); } });
        
        Button b30 = (Button) findViewById(R.id.button30);
        b30.setTextColor(Color.RED);
        b30.setOnClickListener(new OnClickListener() {
    	public void onClick(View v) { showDialog(30); } });
        
        Button b31 = (Button) findViewById(R.id.button31);
        b31.setTextColor(Color.BLACK);
        b31.setOnClickListener(new OnClickListener() {
    	public void onClick(View v) { showDialog(31); } });
        
        Button b32 = (Button) findViewById(R.id.button32);
        b32.setTextColor(Color.RED);
        b32.setOnClickListener(new OnClickListener() {
    	public void onClick(View v) { showDialog(32); } });
        
        Button b33 = (Button) findViewById(R.id.button33);
        b33.setTextColor(Color.BLACK);
        b33.setOnClickListener(new OnClickListener() {
    	public void onClick(View v) { showDialog(33); } });
        
        Button b34 = (Button) findViewById(R.id.button34);
        b34.setTextColor(Color.RED);
        b34.setOnClickListener(new OnClickListener() {
    	public void onClick(View v) { showDialog(34); } });
        
        Button b35 = (Button) findViewById(R.id.button35);
        b35.setTextColor(Color.BLACK);
        b35.setOnClickListener(new OnClickListener() {
    	public void onClick(View v) { showDialog(35); } });
        
        Button b36 = (Button) findViewById(R.id.button36);
        b36.setTextColor(Color.RED);
        b36.setOnClickListener(new OnClickListener() {
    	public void onClick(View v) { showDialog(36); } });
    }
    
    /* MENU */
    public boolean onCreateOptionsMenu(Menu menu) {
        //Création d'un MenuInflater qui va permettre d'instancier un Menu XML en un objet Menu
        MenuInflater inflater = getMenuInflater();
        //Instanciation du menu XML spécifier en un objet Menu
        inflater.inflate(R.layout.menu, menu); 
        return true;
     }
    
    public boolean onOptionsItemSelected(MenuItem item) {
       switch (item.getItemId()) {
          case R.id.annuler:
            if (tabNum.size() > 1) { 
            	tabNum.removeFirst(); 
            	refresh(); 
            }
            else if (tabNum.size() == 1){ 
            	tabNum.remove(0); 
            	reset(); 
            }
            else if (tabNum.size() == 1){
            	Toast.makeText(getApplicationContext(), getString(R.string.error_impossible), Toast.LENGTH_SHORT).show();
            }
            return true;
          case R.id.partager:
        	  final Intent MessIntent = new Intent(Intent.ACTION_SEND);
        	  MessIntent.setType("text/plain");
	       	  MessIntent.putExtra(Intent.EXTRA_TEXT, "https://market.android.com/details?id=com.lucifDev.FreeSmsBombing");
	       	  FreeStatRouletteActivity.this.startActivity(Intent.createChooser(MessIntent, getString(R.string.partager)));
	          return true;
         case R.id.quitter:
             finish();
             return true;
       }
       return false;
    }
    
    
    
    
    /* METHODES DE VALIDATION */
    protected Dialog onCreateDialog(final int num) {
    	// Création d'un boite de dialogue 
    	Dialog dialog;
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	 
    		builder.setMessage(getString(R.string.confirmation) + num + " ?");
    		builder.setCancelable(false);
    		builder.setTitle(getString(R.string.confirmer));
    	 
    		builder.setPositiveButton(getString(R.string.oui),
    			new DialogInterface.OnClickListener() {
    				public void onClick(DialogInterface dialog, int id) {
    					tabAffichage(num);
    					calc(num);
    				}
    			});
    	 
    		builder.setNegativeButton(getString(R.string.non),
    			new DialogInterface.OnClickListener() {
    				public void onClick(DialogInterface dialog, int id) {
    					dialog.cancel();
    				}
    			});
    	 
    		dialog = builder.create();
    		return dialog;
    	}
    
    
    /* METHODES D'INITIALISATION */
	public void initCouleurCase()
	{
		// Initialisation du tableau de couleurs
		tabCoul = new HashMap<Integer, Integer>();
		
		tabCoul.put(0, Color.GREEN);
		tabCoul.put(1, Color.RED);
		tabCoul.put(2, Color.BLACK);
		tabCoul.put(3, Color.RED);
		tabCoul.put(4, Color.BLACK);
		tabCoul.put(5, Color.RED);
		tabCoul.put(6, Color.BLACK);
		tabCoul.put(7, Color.RED);
		tabCoul.put(8, Color.BLACK);
		tabCoul.put(9, Color.RED);
		tabCoul.put(10, Color.BLACK);
		tabCoul.put(11, Color.BLACK);
		tabCoul.put(12, Color.RED);
		tabCoul.put(13, Color.BLACK);
		tabCoul.put(14, Color.RED);
		tabCoul.put(15, Color.BLACK);
		tabCoul.put(16, Color.RED);
		tabCoul.put(17, Color.BLACK);
		tabCoul.put(18, Color.RED);
		tabCoul.put(19, Color.RED);
		tabCoul.put(20, Color.BLACK);
		tabCoul.put(21, Color.RED);
		tabCoul.put(22, Color.BLACK);
		tabCoul.put(23, Color.RED);
		tabCoul.put(24, Color.BLACK);
		tabCoul.put(25, Color.RED);
		tabCoul.put(26, Color.BLACK);
		tabCoul.put(27, Color.RED);
		tabCoul.put(28, Color.BLACK);
		tabCoul.put(29, Color.BLACK);
		tabCoul.put(30, Color.RED);
		tabCoul.put(31, Color.BLACK);
		tabCoul.put(32, Color.RED);
		tabCoul.put(33, Color.BLACK);
		tabCoul.put(34, Color.RED);
		tabCoul.put(35, Color.BLACK);
		tabCoul.put(36, Color.RED);
	}
	
	
	/* METHODES DIVERS */
	public static double myRound(double value, int decimalPlaces)
    {
        if(decimalPlaces < 0) { return value; }
        double augmentation = Math.pow(10, decimalPlaces);
        return Math.round(value * augmentation) / augmentation;
    }
    
    public int getCol(int num)
	{
		String[] tabCol1 = {"1","4","7","10","13","16","19","22","25","28","31","34"};
		String[] tabCol2 = {"2","5","8","11","14","17","20","23","26","29","32","35"};
		//String[] tabCol3 = {"3","6","9","12","15","18","21","24","27","30","33","36"};
		
		for (int i=0 ; i<tabCol1.length ; i++)
		{
			if (tabCol1[i].equalsIgnoreCase(String.valueOf(num))) 	 return 1;
			else if (tabCol2[i].equalsIgnoreCase(String.valueOf(num))) return 2;
		}
		
		return 3;
	}
    
    public boolean isTiers(int num)
    {
    	String[] tiers = {"5","8","10","11","13","16","23","24","27","30","33","36"};
    	for (int i=0 ; i<tiers.length ; i++) { 	if (tiers[i].equalsIgnoreCase(String.valueOf(num))) return true; }
    	return false;
    }
    
    public boolean isOrphelin(int num)
    {
    	String[] orphelin = {"1","6","9","14","17","20","31","34"};
    	for (int i=0 ; i<orphelin.length ; i++) { 	if (orphelin[i].equalsIgnoreCase(String.valueOf(num))) return true; }
    	return false;
    }
    
    public boolean isVoisinZero(int num)
    {
    	String[] voisinZero = {"0","2","3","4","7","12","13","15","18","19","21","22","25","26","28","29","32","35"};
    	for (int i=0 ; i<voisinZero.length ; i++) { 	if (voisinZero[i].equalsIgnoreCase(String.valueOf(num))) return true; }
    	return false;
    }

    public void tabAffichage(int num)
    {
    	String aff = "";
    	
    	if (tabNum.size() == tailleTableau) { tabNum.removeLast(); }
    	
    	tabNum.addFirst((Integer) num);
    	for (int i=0 ; i<tabNum.size() ; i++)
    	{
    		aff += tabNum.get(i) + "\n";
    	}
    	affichage.setText(aff);
    }
    
    //En développement
    public int stat(String choix){
    	int stat=0,num=0,i=0;
    	for (i=0 ; i<tabNum.size() ; i++)
        {
    		num = tabNum.get(i);
        	if (choix.equalsIgnoreCase("rouge") && tabCoul.get(num) == Color.RED) stat++;
        	if (choix.equalsIgnoreCase("noir") && tabCoul.get(num) == Color.BLACK) stat++;
        	
        	if (choix.equalsIgnoreCase("pair") && ((num % 2) == 0) && num != 0) stat++;
        	if (choix.equalsIgnoreCase("impair") && ((num % 2) != 0) && num != 0) stat++;
        	
        	if (choix.equalsIgnoreCase("manque") && ((num >= 1) && (num <= 18))) stat++;
        	if (choix.equalsIgnoreCase("passe") && ((num >= 19) && (num <= 36))) stat++;
        	
        	if (choix.equalsIgnoreCase("p12") && ((num >= 1) && (num <= 12))) stat++;
        	if (choix.equalsIgnoreCase("m12") && ((num >= 13) && (num <= 24))) stat++;
        	if (choix.equalsIgnoreCase("d12") && ((num >= 25) && (num <= 36))) stat++;
        	
        	if (choix.equalsIgnoreCase("col1") && getCol(num) == 1) stat++;
        	if (choix.equalsIgnoreCase("col2") && getCol(num) == 2) stat++;
        	if (choix.equalsIgnoreCase("col3") && getCol(num) == 3) stat++;
        	
        	if (choix.equalsIgnoreCase("tiers") && isTiers(num)) stat++;
        	if (choix.equalsIgnoreCase("voisinzero") && isVoisinZero(num)) stat++;
        	if (choix.equalsIgnoreCase("orphelin") && isOrphelin(num)) stat++;
        }
    	return stat;
    }
    
    public void refresh()
    {
    	int tmp = tabNum.getFirst();
        tabNum.removeFirst();
        tabAffichage(tmp);
        calc(tmp);
    }
    
    public void reset(){
    	tiers .setText("0%");
    	orphelin .setText("0%");
    	voisinZero .setText("0%");
    	p12.setText("0%");
    	m12.setText("0%");
    	d12.setText("0%");
    	manque.setText("0%");
    	passe.setText("0%");
    	pair.setText("0%");
    	impair.setText("0%");
    	rouge.setText("0%");
    	noir.setText("0%");
    	col1.setText("0%");
    	col2.setText("0%");
    	col3.setText("0%");
    	tiers .setText("0%");
    	orphelin .setText("0%");
    	voisinZero .setText("0%");
    	affichage.setText("");
    }
    
    /* METHODES DE CALCUL */
    public void calc(int num)
    {    	
    	//Exception de la division par 0 
    	if (tabNum.size() == 1 && num == 0)
    	{	
    		//On calcul les Tiers/Orphelin/VoisinZero
        	tiers .setText(myRound((stat("tiers") * 100) / (stat("tiers") + stat("orphelin") + stat("voisinZero")),1) + "%");
        	orphelin .setText(myRound((stat("orphelin") * 100) / (stat("tiers") + stat("orphelin") + stat("voisinZero")),1) + "%");
        	voisinZero .setText(myRound((stat("voisinZero") * 100) / (stat("tiers") + stat("orphelin") + stat("voisinZero")),1) + "%");
    	}
    	else
    	{
	    	//On calcul les tiers
	    	p12.setText(myRound((stat("p12") * 100) / (stat("p12") + stat("m12") + stat("d12")),1) + "%");
	    	m12.setText(myRound((stat("m12") * 100) / (stat("p12") + stat("m12") + stat("d12")),1) + "%");
	    	d12.setText(myRound((stat("d12") * 100) / (stat("p12") + stat("m12") + stat("d12")),1) + "%");
	    			
	    	//On calcul les passe/manque
	    	manque.setText( myRound((stat("manque") * 100) / (stat("passe") + stat("manque")),1) + "%");
	    	passe.setText( myRound((stat("passe") * 100) / (stat("passe") + stat("manque")),1) + "%");
	    	
	    	//On calculc les pairs/impairs
	    	pair.setText( myRound((stat("pair") * 100) / (stat("pair") + stat("impair")),1) + "%");
	    	impair.setText( myRound((stat("impair") * 100) / (stat("pair") + stat("impair")),1) + "%");
	    			
	    	//On calcul les rouge/noir
	    	rouge.setText(myRound((stat("rouge") * 100) / (stat("rouge") + stat("noir")),1) + "%");
	    	noir.setText( myRound((stat("noir") * 100) / (stat("rouge") + stat("noir")),1) + "%");
	    			
	    	//On calcul les colonnes
	    	col1.setText(myRound((stat("col1") * 100) / (stat("col1") + stat("col2") + stat("col3")),1) + "%");
	    	col2.setText(myRound((stat("col2") * 100) / (stat("col1") + stat("col2") + stat("col3")),1) + "%");
	    	col3.setText(myRound((stat("col3")* 100) / (stat("col1") + stat("col2") + stat("col3")),1) + "%");
	    	
    		//On calcul les Tiers/Orphelin/VoisinZero
        	tiers .setText(myRound((stat("tiers") * 100) / (stat("tiers") + stat("orphelin") + stat("voisinZero")),1) + "%");
        	orphelin .setText(myRound((stat("orphelin") * 100) / (stat("tiers") + stat("orphelin") + stat("voisinZero")),1) + "%");
        	voisinZero .setText(myRound((stat("voisinZero") * 100) / (stat("tiers") + stat("orphelin") + stat("voisinZero")),1) + "%");
    	}
    }
}