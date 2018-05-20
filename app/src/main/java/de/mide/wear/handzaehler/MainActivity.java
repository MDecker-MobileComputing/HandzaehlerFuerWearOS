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

    /** Java-Objekt für Plus-Button auf UI. */
    protected Button _plusButton = null;

    /** Java-Objekt für Plus-Button auf UI. */
    protected Button _minusButton = null;


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


        _plusButton  = findViewById( R.id.plusButton  );
        _minusButton = findViewById( R.id.minusButton );

        MeinButtonEventHandler mbeh = new MeinButtonEventHandler(this);

        _plusButton.setOnClickListener ( mbeh );
        _minusButton.setOnClickListener( mbeh );

        setAmbientEnabled(); // Enables Always-on
    }


    public Button getPlusButton() {
        return _plusButton;
    }

    public Button getMinusButton() {
        return _minusButton;
    }

    public void erhoeheZaehlerUmEins() {
        _zaehler++;
    }

    public void vermindereZaehlerUmEins() {
        _zaehler--;
    }


    /**
     * Text von UI-Element mit Zähler-Wert aktualisieren.
     */
    protected void aktualisiereZaehlerAnzeige() {
        _zahlTextView.setText( _zaehler + "" );
    }


    /**
     * Event-Handler-Methode für Betätigung des Plus- oder Minus-Buttons.
     *
     * @param v Referenz auf Objekt, welches das Event ausgelöst hatte
     *          (also Button, der "gedrückt" wurde).
     */


}

