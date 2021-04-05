package com.mexator.petfoodinspector

import com.mexator.petfoodinspector.data.Repository
import org.junit.Assert
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class RepositoryTest {
    @Before
    fun setup(){
        Repository.reset()
    }

    @Test
    fun testNoLogin() {
        try {
            Repository.getUser()
            Assert.fail("No user logged in - fail")
        } catch (a: IllegalAccessError) {
        }
    }

    @Test
    fun testLogin() {
        val repo = Repository
        repo.login()
        Assert.assertTrue(repo.getUser().login == "Antoxa")
    }
}