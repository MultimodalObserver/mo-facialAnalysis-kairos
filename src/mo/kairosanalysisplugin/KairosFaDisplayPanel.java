/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mo.kairosanalysisplugin;

import facialAnalysisCore.FacialAnalysis;
import facialAnalysisCore.Instant;
import facialAnalysisCore.Person;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.Marker;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author gustavo
 */
public class KairosFaDisplayPanel extends javax.swing.JPanel {

   private Person source;
   private JFreeChart linesGrafic;
   private JFreeChart areaGrafic;

   private ValueMarker marker;
   private long offset;
   private ChartPanel chartPanel;
   private XYSeriesCollection linesDatasetContainer;
   private XYSeriesCollection areaDatasetContainer;
   private XYSeries linesSeries[];
   private XYSeries areaSeries[];

   private ArrayList<JCheckBoxMenuItem> graficChecks;
    
    public JPanel getPanel(){
        return this;
    }
    

    
    public KairosFaDisplayPanel(Person source, long offset) {
        initComponents();
        this.offset = offset;
        //this.offset=0;
        
        
        
        if(source != null){
                       
            linesSeries = new XYSeries[source.getEmotions().size()];
            areaSeries = new XYSeries[source.getEmotions().size()];;     
            
            this.linesGrafic = this.makeLineGraficPerson(source);
            this.areaGrafic = this.makeAreaGraficPerson(source);
            ChartPanel panel = new ChartPanel(this.linesGrafic); 
            this.chartPanel = panel;
            
            panel.setPopupMenu(mainJpopMenu);
            
            this.setLayout(new java.awt.BorderLayout());
            this.add(panel);   
            this.validate();
            
            //crando marcador
           this.marker= new ValueMarker(0);
            marker.setStroke(new BasicStroke(1.0f));
            marker.setPaint(Color.black);
           this.linesGrafic.getXYPlot().addDomainMarker(marker);
           this.areaGrafic.getXYPlot().addDomainMarker(marker);

           this.linesRadioButtonMenuItem.setSelected(true);
           this.areaRadioButtonMenuItem.setSelected(false);
      

           graficChecks = new  ArrayList<JCheckBoxMenuItem>();

           for(int i=0; i<source.getEmotions().size(); i++ ){
               
               JCheckBoxMenuItem jcheck = new  JCheckBoxMenuItem();
               jcheck.setSelected(true);
               jcheck.setText(source.getEmotion(i).getName());
               this.graficsMenu.add(jcheck);
               jcheck.addActionListener(new checkListenner(i));
               graficChecks.add(jcheck);          
           }
           
           
        }else{
            //nada
        }
    }

    class checkListenner implements java.awt.event.ActionListener {

        private int index;
        public checkListenner(int index){
            this.index = index;
        } 
        
        @Override
        public void actionPerformed(ActionEvent e) {
             changeBoxActionPerformed(e, index) ; 
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainJpopMenu = new javax.swing.JPopupMenu();
        propertiesMenuItem = new javax.swing.JMenuItem();
        copyMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        graficsMenu = new javax.swing.JMenu();
        graficTypeMenu = new javax.swing.JMenu();
        linesRadioButtonMenuItem = new javax.swing.JRadioButtonMenuItem();
        areaRadioButtonMenuItem = new javax.swing.JRadioButtonMenuItem();

        propertiesMenuItem.setText("Propiedades");
        propertiesMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                propertiesMenuItemMouseClicked(evt);
            }
        });
        propertiesMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                propertiesMenuItemActionPerformed(evt);
            }
        });
        mainJpopMenu.add(propertiesMenuItem);

        copyMenuItem.setText("copiar");
        copyMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                copyMenuItemMouseClicked(evt);
            }
        });
        copyMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyMenuItemActionPerformed(evt);
            }
        });
        mainJpopMenu.add(copyMenuItem);

        saveAsMenuItem.setText("Guardar como");
        saveAsMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveAsMenuItemMouseClicked(evt);
            }
        });
        saveAsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsMenuItemActionPerformed(evt);
            }
        });
        mainJpopMenu.add(saveAsMenuItem);

        graficsMenu.setText("Graficos");
        mainJpopMenu.add(graficsMenu);

        graficTypeMenu.setText("Tipo de grafico");

        linesRadioButtonMenuItem.setSelected(true);
        linesRadioButtonMenuItem.setText("Lineas");
        linesRadioButtonMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linesRadioButtonMenuItemActionPerformed(evt);
            }
        });
        graficTypeMenu.add(linesRadioButtonMenuItem);

        areaRadioButtonMenuItem.setSelected(true);
        areaRadioButtonMenuItem.setText("Area");
        areaRadioButtonMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                areaRadioButtonMenuItemActionPerformed(evt);
            }
        });
        graficTypeMenu.add(areaRadioButtonMenuItem);

        mainJpopMenu.add(graficTypeMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void propertiesMenuItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_propertiesMenuItemMouseClicked
       this.chartPanel.doEditChartProperties();
    }//GEN-LAST:event_propertiesMenuItemMouseClicked

    private void copyMenuItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_copyMenuItemMouseClicked
        this.chartPanel.doCopy();
    }//GEN-LAST:event_copyMenuItemMouseClicked

    private void saveAsMenuItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveAsMenuItemMouseClicked
       try {
           this.chartPanel.doSaveAs();
       } catch (IOException ex) {
           Logger.getLogger(KairosFaDisplayPanel.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_saveAsMenuItemMouseClicked

    private void propertiesMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_propertiesMenuItemActionPerformed
       this.chartPanel.doEditChartProperties();
    }//GEN-LAST:event_propertiesMenuItemActionPerformed

    private void copyMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyMenuItemActionPerformed
        this.chartPanel.doCopy();
    }//GEN-LAST:event_copyMenuItemActionPerformed

    private void saveAsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsMenuItemActionPerformed
       try {
           this.chartPanel.doSaveAs();
       } catch (IOException ex) {
           Logger.getLogger(KairosFaDisplayPanel.class.getName()).log(Level.SEVERE, null, ex);
       }    }//GEN-LAST:event_saveAsMenuItemActionPerformed

    private void linesRadioButtonMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linesRadioButtonMenuItemActionPerformed
        this.chartPanel.setChart(linesGrafic);
        this.areaRadioButtonMenuItem.setSelected(false);
    }//GEN-LAST:event_linesRadioButtonMenuItemActionPerformed

    private void areaRadioButtonMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_areaRadioButtonMenuItemActionPerformed
        this.chartPanel.setChart(areaGrafic);
        this.linesRadioButtonMenuItem.setSelected(false);
    }//GEN-LAST:event_areaRadioButtonMenuItemActionPerformed

    private void changeBoxActionPerformed(java.awt.event.ActionEvent evt, int index) {                                                        

        
        if(!this.graficChecks.get(index).isSelected()){
             this.linesDatasetContainer.removeSeries(this.linesSeries[index]);
             this.areaDatasetContainer.removeSeries(this.linesSeries[index]);
         }
         else{
             this.linesDatasetContainer.addSeries(this.linesSeries[index]);
             this.areaDatasetContainer.addSeries(this.linesSeries[index]);      
         }
    }                                                           
    
    public void display(Instant instant){
        this.marker.setValue(instant.getTime());
    }
    
     public void clear(){
        this.marker.setValue(0);
    }
     
    public void seekMarker(long value){
        this.marker.setValue(value-offset);
    }
    
   public JFreeChart makeLineGraficPerson(Person p){
        
           JFreeChart grafic = null  ;
           XYSeries series0 = new XYSeries(p.getEmotion(0).getName());
           XYSeries series1 = new XYSeries(p.getEmotion(1).getName());
           XYSeries series2 = new XYSeries(p.getEmotion(2).getName());
           XYSeries series3 = new XYSeries(p.getEmotion(3).getName());
           XYSeries series4 = new XYSeries(p.getEmotion(4).getName());
           XYSeries series5 = new XYSeries(p.getEmotion(5).getName());
           
           this.linesSeries[0] = series0;
           this.linesSeries[1] = series1;           
           this.linesSeries[2] = series2;
           this.linesSeries[3] = series3;
           this.linesSeries[4] = series4;
           this.linesSeries[5] = series5;           
           
           for(int i=0; i<p.getEmotion(0).getInstants().size();i++){   
                series0.add(p.getEmotion(0).getInstants().get(i).getTime()-offset,p.getEmotion(0).getInstants().get(i).getValue());
                series1.add(p.getEmotion(1).getInstants().get(i).getTime()-offset,p.getEmotion(1).getInstants().get(i).getValue());
                series2.add(p.getEmotion(2).getInstants().get(i).getTime()-offset,p.getEmotion(2).getInstants().get(i).getValue());
                series3.add(p.getEmotion(3).getInstants().get(i).getTime()-offset,p.getEmotion(3).getInstants().get(i).getValue());
                series4.add(p.getEmotion(4).getInstants().get(i).getTime()-offset,p.getEmotion(4).getInstants().get(i).getValue());
                series5.add(p.getEmotion(5).getInstants().get(i).getTime()-offset,p.getEmotion(5).getInstants().get(i).getValue());
           }
           
           XYSeriesCollection dataset = new XYSeriesCollection();
           linesDatasetContainer = dataset;

           dataset.addSeries(series0);           
           dataset.addSeries(series1);
           dataset.addSeries(series2);
           dataset.addSeries(series3);
           dataset.addSeries(series4);
           dataset.addSeries(series5);
           
           grafic = ChartFactory.createXYLineChart("Emotions","","Nivel %", dataset);
           
           grafic.setAntiAlias(true);
           grafic.setBackgroundPaint(Color.WHITE);
           grafic.getPlot().setOutlineVisible(false);
           grafic.getPlot().setBackgroundPaint(Color.WHITE);
           grafic.setBorderVisible(false);
                           grafic.getXYPlot().setDomainGridlinesVisible(false);
                grafic.getXYPlot().setRangeGridlinePaint(Color.DARK_GRAY);
                grafic.getXYPlot().getRangeAxis().setAxisLineVisible(false);
                grafic.setTitle("");
                
               
                
          // grafic.getXYPlot().s
                
           return grafic;       
    }

   public JFreeChart makeAreaGraficPerson(Person p){
        
           JFreeChart grafic = null  ;
           XYSeries series0 = new XYSeries(p.getEmotion(0).getName());
           XYSeries series1 = new XYSeries(p.getEmotion(1).getName());
           XYSeries series2 = new XYSeries(p.getEmotion(2).getName());
           XYSeries series3 = new XYSeries(p.getEmotion(3).getName());
           XYSeries series4 = new XYSeries(p.getEmotion(4).getName());
           XYSeries series5 = new XYSeries(p.getEmotion(5).getName());
           
           this.areaSeries[0] = series0;
           this.areaSeries[1] = series1;           
           this.areaSeries[2] = series2;
           this.areaSeries[3] = series3;
           this.areaSeries[4] = series4;
           this.areaSeries[5] = series5;
           
           for(int i=0; i<p.getEmotion(0).getInstants().size();i++){   
                series0.add(p.getEmotion(0).getInstants().get(i).getTime()-offset,p.getEmotion(0).getInstants().get(i).getValue());
                series1.add(p.getEmotion(1).getInstants().get(i).getTime()-offset,p.getEmotion(1).getInstants().get(i).getValue());
                series2.add(p.getEmotion(2).getInstants().get(i).getTime()-offset,p.getEmotion(2).getInstants().get(i).getValue());
                series3.add(p.getEmotion(3).getInstants().get(i).getTime()-offset,p.getEmotion(3).getInstants().get(i).getValue());
                series4.add(p.getEmotion(4).getInstants().get(i).getTime()-offset,p.getEmotion(4).getInstants().get(i).getValue());
                series5.add(p.getEmotion(5).getInstants().get(i).getTime()-offset,p.getEmotion(5).getInstants().get(i).getValue());
           }
           
           XYSeriesCollection dataset = new XYSeriesCollection();
            areaDatasetContainer= dataset;

           dataset.addSeries(series0);           
           dataset.addSeries(series1);
           dataset.addSeries(series2);
           dataset.addSeries(series3);
           dataset.addSeries(series4);
           dataset.addSeries(series5);
           
           grafic = ChartFactory.createXYAreaChart("Emotions","","Nivel %", dataset);

           grafic.setAntiAlias(true);
           grafic.setBackgroundPaint(Color.WHITE);
           grafic.getPlot().setOutlineVisible(false);
           grafic.getPlot().setBackgroundPaint(Color.WHITE);
           grafic.setBorderVisible(false);
                           grafic.getXYPlot().setDomainGridlinesVisible(false);
                grafic.getXYPlot().setRangeGridlinePaint(Color.DARK_GRAY);
                grafic.getXYPlot().getRangeAxis().setAxisLineVisible(false);
                grafic.setTitle("");
                
               
                
          // grafic.getXYPlot().s
                
           return grafic;       
    }
   
   
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButtonMenuItem areaRadioButtonMenuItem;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenu graficTypeMenu;
    private javax.swing.JMenu graficsMenu;
    private javax.swing.JRadioButtonMenuItem linesRadioButtonMenuItem;
    private javax.swing.JPopupMenu mainJpopMenu;
    private javax.swing.JMenuItem propertiesMenuItem;
    private javax.swing.JMenuItem saveAsMenuItem;
    // End of variables declaration//GEN-END:variables
}
