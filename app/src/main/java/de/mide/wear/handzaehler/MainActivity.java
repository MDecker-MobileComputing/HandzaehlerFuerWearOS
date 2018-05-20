package de.mide.wear.handzaehler;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.OnClick;


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

        ButterKnife.bind(this); // !!! Nicht vergessen !!!

        setAmbientEnabled(); // Enables Always-on
    }


    /**
     * Text von UI-Element mit Zähler-Wert aktualisieren.
     */
    protected void aktualisiereZaehlerAnzeige() {
        _zahlTextView.setText( _zaehler + "" );
    }


    /** Methode wird über Butterknife-Annotation als Event-Handler zugewiesen. */
    @OnClick(R.id.plusButton)
    public void onPlusButton() {
        _zaehler++;
        aktualisiereZaehlerAnzeige();
    }

    /** Methode wird über Butterknife-Annotation als Event-Handler zugewiesen. */
    @OnClick(R.id.minusButton)
    public void onMinusButton() {
        _zaehler--;
        aktualisiereZaehlerAnzeige();
    }

}

