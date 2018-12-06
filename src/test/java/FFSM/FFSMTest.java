/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FFSM;

import FFSSM.Club;
import FFSSM.GroupeSanguin;
import FFSSM.Licence;
import FFSSM.Moniteur;
import FFSSM.Personne;
import FFSSM.Plongee;
import FFSSM.Plongeur;
import FFSSM.Site;
import java.util.Calendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author adarribe
 */
public class FFSMTest {
    public Calendar d_d_n;
    public Calendar d1;
    public Calendar d2;
    public Calendar dateadri;
    public Licence l_1;
    public Licence l_2;
    public Plongeur p_1;
    public Plongeur p_2;
    public Moniteur m_1;
    public Club club;
    public Personne Michel;
    public Plongee plongee;
    public Site site;

    public FFSMTest() {
    }

   
    @Before
    public void setUp() {
        Calendar ddn = Calendar.getInstance();
        Calendar d1 = Calendar.getInstance();
        Calendar d2 =  Calendar.getInstance();
        Calendar dateadri = Calendar.getInstance();
        dateadri.set(2019,01,01);
        d1.set(2017,10,30);
        d2.set(2014,12,14);
        d_d_n.set(1984, 9,3);
        Personne Michel = new Personne("1","Michel","Michel","14 Avenue des Michel","06.23.45.78.94",d_d_n);
        Licence l_1 = new Licence(Michel,"1",d1,4);
        Licence l_2 = new Licence(Michel,"2",d2,2);
        Plongeur p_1 = new Plongeur("2","Curt","Bryan","20 Rue des Bryan","06.24.58.94.21",d_d_n,4,l_2,GroupeSanguin.BMOINS);
        Plongeur p_2 = new Plongeur("3","Broucke","Hugo","10 Rue de Hugo","06.23.45.12.65",d_d_n,3,l_1,GroupeSanguin.AMOINS);
        Club club = new Club(m_1,"Plouf","05.63.45.58.95");
        Site site = new Site("oui","test");
        Plongee plongee = new Plongee(site,m_1,dateadri,4,4);
        l_1.setClub(club);
        this.d_d_n = ddn;
        this.d1 = d1;
        this.d2 = d2;
        this.Michel = Michel;
        this.l_1 = l_1;
        this.l_2 = l_2;
        this.p_1 = p_1;
        this.p_2 = p_2;
        this.m_1 = m_1;
        this.club = club;
        this.dateadri = dateadri;
        this.site = site;
        this.plongee = plongee;
    }
    
    @Test
    public void testLicence(){
        assertEquals(true,l_1.estValide(dateadri));
        assertEquals(false,l_2.estValide(dateadri));
    }
    
    @Test
    public void testPlongee(){
        plongee.ajouteParticipant(m_1);
        assertEquals(1,plongee.myPlongeurs.size());
        assertEquals(true,plongee.estConforme());
        plongee.ajouteParticipant(p_1);
        assertEquals(false,plongee.estConforme());
    }

}