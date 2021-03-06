// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.sav.domain;

import com.sav.domain.AdressRetourDataOnDemand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

privileged aspect AdressRetourIntegrationTest_Roo_IntegrationTest {
    
    declare @type: AdressRetourIntegrationTest: @RunWith(SpringJUnit4ClassRunner.class);
    
    declare @type: AdressRetourIntegrationTest: @ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext.xml");
    
    declare @type: AdressRetourIntegrationTest: @Transactional;
    
    @Autowired
    private AdressRetourDataOnDemand AdressRetourIntegrationTest.dod;
    
    @Test
    public void AdressRetourIntegrationTest.testCountAdressRetours() {
        org.junit.Assert.assertNotNull("Data on demand for 'AdressRetour' failed to initialize correctly", dod.getRandomAdressRetour());
        long count = com.sav.domain.AdressRetour.countAdressRetours();
        org.junit.Assert.assertTrue("Counter for 'AdressRetour' incorrectly reported there were no entries", count > 0);
    }
    
    @Test
    public void AdressRetourIntegrationTest.testFindAdressRetour() {
        com.sav.domain.AdressRetour obj = dod.getRandomAdressRetour();
        org.junit.Assert.assertNotNull("Data on demand for 'AdressRetour' failed to initialize correctly", obj);
        java.lang.Long id = obj.getId();
        org.junit.Assert.assertNotNull("Data on demand for 'AdressRetour' failed to provide an identifier", id);
        obj = com.sav.domain.AdressRetour.findAdressRetour(id);
        org.junit.Assert.assertNotNull("Find method for 'AdressRetour' illegally returned null for id '" + id + "'", obj);
        org.junit.Assert.assertEquals("Find method for 'AdressRetour' returned the incorrect identifier", id, obj.getId());
    }
    
    @Test
    public void AdressRetourIntegrationTest.testFindAllAdressRetours() {
        org.junit.Assert.assertNotNull("Data on demand for 'AdressRetour' failed to initialize correctly", dod.getRandomAdressRetour());
        long count = com.sav.domain.AdressRetour.countAdressRetours();
        org.junit.Assert.assertTrue("Too expensive to perform a find all test for 'AdressRetour', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        java.util.List<com.sav.domain.AdressRetour> result = com.sav.domain.AdressRetour.findAllAdressRetours();
        org.junit.Assert.assertNotNull("Find all method for 'AdressRetour' illegally returned null", result);
        org.junit.Assert.assertTrue("Find all method for 'AdressRetour' failed to return any data", result.size() > 0);
    }
    
    @Test
    public void AdressRetourIntegrationTest.testFindAdressRetourEntries() {
        org.junit.Assert.assertNotNull("Data on demand for 'AdressRetour' failed to initialize correctly", dod.getRandomAdressRetour());
        long count = com.sav.domain.AdressRetour.countAdressRetours();
        if (count > 20) count = 20;
        java.util.List<com.sav.domain.AdressRetour> result = com.sav.domain.AdressRetour.findAdressRetourEntries(0, (int) count);
        org.junit.Assert.assertNotNull("Find entries method for 'AdressRetour' illegally returned null", result);
        org.junit.Assert.assertEquals("Find entries method for 'AdressRetour' returned an incorrect number of entries", count, result.size());
    }
    
    @Test
    public void AdressRetourIntegrationTest.testFlush() {
        com.sav.domain.AdressRetour obj = dod.getRandomAdressRetour();
        org.junit.Assert.assertNotNull("Data on demand for 'AdressRetour' failed to initialize correctly", obj);
        java.lang.Long id = obj.getId();
        org.junit.Assert.assertNotNull("Data on demand for 'AdressRetour' failed to provide an identifier", id);
        obj = com.sav.domain.AdressRetour.findAdressRetour(id);
        org.junit.Assert.assertNotNull("Find method for 'AdressRetour' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyAdressRetour(obj);
        java.lang.Integer currentVersion = obj.getVersion();
        obj.flush();
        org.junit.Assert.assertTrue("Version for 'AdressRetour' failed to increment on flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }
    
    @Test
    public void AdressRetourIntegrationTest.testMerge() {
        com.sav.domain.AdressRetour obj = dod.getRandomAdressRetour();
        org.junit.Assert.assertNotNull("Data on demand for 'AdressRetour' failed to initialize correctly", obj);
        java.lang.Long id = obj.getId();
        org.junit.Assert.assertNotNull("Data on demand for 'AdressRetour' failed to provide an identifier", id);
        obj = com.sav.domain.AdressRetour.findAdressRetour(id);
        boolean modified =  dod.modifyAdressRetour(obj);
        java.lang.Integer currentVersion = obj.getVersion();
        com.sav.domain.AdressRetour merged =  obj.merge();
        obj.flush();
        org.junit.Assert.assertEquals("Identifier of merged object not the same as identifier of original object", merged.getId(), id);
        org.junit.Assert.assertTrue("Version for 'AdressRetour' failed to increment on merge and flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }
    
    @Test
    public void AdressRetourIntegrationTest.testPersist() {
        org.junit.Assert.assertNotNull("Data on demand for 'AdressRetour' failed to initialize correctly", dod.getRandomAdressRetour());
        com.sav.domain.AdressRetour obj = dod.getNewTransientAdressRetour(Integer.MAX_VALUE);
        org.junit.Assert.assertNotNull("Data on demand for 'AdressRetour' failed to provide a new transient entity", obj);
        org.junit.Assert.assertNull("Expected 'AdressRetour' identifier to be null", obj.getId());
        obj.persist();
        obj.flush();
        org.junit.Assert.assertNotNull("Expected 'AdressRetour' identifier to no longer be null", obj.getId());
    }
    
    @Test
    public void AdressRetourIntegrationTest.testRemove() {
        com.sav.domain.AdressRetour obj = dod.getRandomAdressRetour();
        org.junit.Assert.assertNotNull("Data on demand for 'AdressRetour' failed to initialize correctly", obj);
        java.lang.Long id = obj.getId();
        org.junit.Assert.assertNotNull("Data on demand for 'AdressRetour' failed to provide an identifier", id);
        obj = com.sav.domain.AdressRetour.findAdressRetour(id);
        obj.remove();
        obj.flush();
        org.junit.Assert.assertNull("Failed to remove 'AdressRetour' with identifier '" + id + "'", com.sav.domain.AdressRetour.findAdressRetour(id));
    }
    
}
