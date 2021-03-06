// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.sav.domain;

import com.sav.domain.PieceDataOnDemand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

privileged aspect PieceIntegrationTest_Roo_IntegrationTest {
    
    declare @type: PieceIntegrationTest: @RunWith(SpringJUnit4ClassRunner.class);
    
    declare @type: PieceIntegrationTest: @ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext.xml");
    
    declare @type: PieceIntegrationTest: @Transactional;
    
    @Autowired
    private PieceDataOnDemand PieceIntegrationTest.dod;
    
    @Test
    public void PieceIntegrationTest.testCountPieces() {
        org.junit.Assert.assertNotNull("Data on demand for 'Piece' failed to initialize correctly", dod.getRandomPiece());
        long count = com.sav.domain.Piece.countPieces();
        org.junit.Assert.assertTrue("Counter for 'Piece' incorrectly reported there were no entries", count > 0);
    }
    
    @Test
    public void PieceIntegrationTest.testFindPiece() {
        com.sav.domain.Piece obj = dod.getRandomPiece();
        org.junit.Assert.assertNotNull("Data on demand for 'Piece' failed to initialize correctly", obj);
        java.lang.Long id = obj.getId();
        org.junit.Assert.assertNotNull("Data on demand for 'Piece' failed to provide an identifier", id);
        obj = com.sav.domain.Piece.findPiece(id);
        org.junit.Assert.assertNotNull("Find method for 'Piece' illegally returned null for id '" + id + "'", obj);
        org.junit.Assert.assertEquals("Find method for 'Piece' returned the incorrect identifier", id, obj.getId());
    }
    
    @Test
    public void PieceIntegrationTest.testFindAllPieces() {
        org.junit.Assert.assertNotNull("Data on demand for 'Piece' failed to initialize correctly", dod.getRandomPiece());
        long count = com.sav.domain.Piece.countPieces();
        org.junit.Assert.assertTrue("Too expensive to perform a find all test for 'Piece', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        java.util.List<com.sav.domain.Piece> result = com.sav.domain.Piece.findAllPieces();
        org.junit.Assert.assertNotNull("Find all method for 'Piece' illegally returned null", result);
        org.junit.Assert.assertTrue("Find all method for 'Piece' failed to return any data", result.size() > 0);
    }
    
    @Test
    public void PieceIntegrationTest.testFindPieceEntries() {
        org.junit.Assert.assertNotNull("Data on demand for 'Piece' failed to initialize correctly", dod.getRandomPiece());
        long count = com.sav.domain.Piece.countPieces();
        if (count > 20) count = 20;
        java.util.List<com.sav.domain.Piece> result = com.sav.domain.Piece.findPieceEntries(0, (int) count);
        org.junit.Assert.assertNotNull("Find entries method for 'Piece' illegally returned null", result);
        org.junit.Assert.assertEquals("Find entries method for 'Piece' returned an incorrect number of entries", count, result.size());
    }
    
    @Test
    public void PieceIntegrationTest.testFlush() {
        com.sav.domain.Piece obj = dod.getRandomPiece();
        org.junit.Assert.assertNotNull("Data on demand for 'Piece' failed to initialize correctly", obj);
        java.lang.Long id = obj.getId();
        org.junit.Assert.assertNotNull("Data on demand for 'Piece' failed to provide an identifier", id);
        obj = com.sav.domain.Piece.findPiece(id);
        org.junit.Assert.assertNotNull("Find method for 'Piece' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyPiece(obj);
        java.lang.Integer currentVersion = obj.getVersion();
        obj.flush();
        org.junit.Assert.assertTrue("Version for 'Piece' failed to increment on flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }
    
    @Test
    public void PieceIntegrationTest.testMerge() {
        com.sav.domain.Piece obj = dod.getRandomPiece();
        org.junit.Assert.assertNotNull("Data on demand for 'Piece' failed to initialize correctly", obj);
        java.lang.Long id = obj.getId();
        org.junit.Assert.assertNotNull("Data on demand for 'Piece' failed to provide an identifier", id);
        obj = com.sav.domain.Piece.findPiece(id);
        boolean modified =  dod.modifyPiece(obj);
        java.lang.Integer currentVersion = obj.getVersion();
        com.sav.domain.Piece merged =  obj.merge();
        obj.flush();
        org.junit.Assert.assertEquals("Identifier of merged object not the same as identifier of original object", merged.getId(), id);
        org.junit.Assert.assertTrue("Version for 'Piece' failed to increment on merge and flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }
    
    @Test
    public void PieceIntegrationTest.testPersist() {
        org.junit.Assert.assertNotNull("Data on demand for 'Piece' failed to initialize correctly", dod.getRandomPiece());
        com.sav.domain.Piece obj = dod.getNewTransientPiece(Integer.MAX_VALUE);
        org.junit.Assert.assertNotNull("Data on demand for 'Piece' failed to provide a new transient entity", obj);
        org.junit.Assert.assertNull("Expected 'Piece' identifier to be null", obj.getId());
        obj.persist();
        obj.flush();
        org.junit.Assert.assertNotNull("Expected 'Piece' identifier to no longer be null", obj.getId());
    }
    
    @Test
    public void PieceIntegrationTest.testRemove() {
        com.sav.domain.Piece obj = dod.getRandomPiece();
        org.junit.Assert.assertNotNull("Data on demand for 'Piece' failed to initialize correctly", obj);
        java.lang.Long id = obj.getId();
        org.junit.Assert.assertNotNull("Data on demand for 'Piece' failed to provide an identifier", id);
        obj = com.sav.domain.Piece.findPiece(id);
        obj.remove();
        obj.flush();
        org.junit.Assert.assertNull("Failed to remove 'Piece' with identifier '" + id + "'", com.sav.domain.Piece.findPiece(id));
    }
    
}
