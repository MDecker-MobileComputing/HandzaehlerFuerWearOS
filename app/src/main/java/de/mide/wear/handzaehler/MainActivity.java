package de.mide.wear.handzaehler;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends WearableActivity {


    /** Member-Variable mit dem aktuellen Zähler-Wert. */
    protected int _zaehler = -1;

    /** Referenz auf Java-Objekt, das TextView-Element
     *  mit Zähler-Wert repräsentiert.
     */
    protected TextView _zahlTextView = null;


    /**
     * Lifecycle-Methode: Lädt Layout-Datei,
     * initialisiert Zähler-Variable, füllt
     * Member-Variablen für die UI-Elemente,
     * registriert "this"-Objekt als Event-
     * Handler-Objekt für die beiden Buttons.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _zaehler = 0;

        _zahlTextView = findViewById( R.id.zahlTextView );

        aktualisiereZaehlerAnzeige();

        setAmbientEnabled(); // Enables Always-on
    }


    /**
     * Text von UI-Element mit Zähler-Wert aktualisieren.
     */
    protected void aktualisiereZaehlerAnzeige() {
        _zahlTextView.setText( _zaehler + "" );
    }


    /** Methode wird in Layout-Datei über XML-Attribut zugewiesen. */
    public void onPlusButton(View v) {
        _zaehler++;
        aktualisiereZaehlerAnzeige();
    }

    /** Methode wird in Layout-Datei über XML-Attribut zugewiesen. */
    public void onMinusButton(View v) {
        _zaehler--;
        aktualisiereZaehlerAnzeige();
    }

}

