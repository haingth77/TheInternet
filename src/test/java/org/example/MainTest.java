package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTest {
    @Test
    void fourLaSoChan(){
        Assert.assertTrue(Main.kiemTraSoChan(4));
    }

    @Test
    void fiveLaSoLe(){
        Assert.assertFalse(Main.kiemTraSoChan(5));
    }

    @Test
    void aLaNguyenAm(){
        Assert.assertTrue(Main.kiemTraNguyenAmHai('a'));
    }

    @Test
    void ALaNguyenAm(){
        Assert.assertTrue(Main.kiemTraNguyenAmHai('A'));
    }

    @Test
    void eLaNguyenAm(){
        Assert.assertTrue(Main.kiemTraNguyenAmHai('e'));
    }
    @Test
    void ELaNguyenAm(){
        Assert.assertTrue(Main.kiemTraNguyenAmHai('E'));
    }
    @Test
    void oLaNguyenAm(){
        Assert.assertTrue(Main.kiemTraNguyenAmHai('o'));
    }
    @Test
    void OLaNguyenAm(){
        Assert.assertTrue(Main.kiemTraNguyenAmHai('O'));
    }
    @Test
    void uLaNguyenAm(){
        Assert.assertTrue(Main.kiemTraNguyenAmHai('U'));
    }
    @Test
    void iLaNguyenAm(){
        Assert.assertTrue(Main.kiemTraNguyenAmHai('i'));
    }
    @Test
    void ILaNguyenAm(){
        Assert.assertTrue(Main.kiemTraNguyenAmHai('I'));
    }

    @Test
    void kyTuDacBietKhongLaNguyenAm(){
        Assert.assertFalse(Main.kiemTraNguyenAmHai('*'));
    }

    @Test
    void numberKhongLaNguyenAm(){
        Assert.assertFalse(Main.kiemTraNguyenAmHai('1'));
    }

    @Test
    void so3LaSoNguyenTo(){
        Assert.assertTrue(Main.kiemTraSoNguyenTo(3));
    }

    @Test
    void so6KhongLaSoNguyenTo(){
        Assert.assertFalse(Main.kiemTraSoNguyenTo(6));
    }
    @Test
    void so59LaSoNguyenTo(){
        Assert.assertTrue(Main.kiemTraSoNguyenTo(59));
    }

    @Test
    void soamKhongLaSoNguyenTo() {
        Assert.assertFalse(Main.kiemTraSoNguyenTo(-59));
    }

    @Test
    void so0KhongLaSoNguyenTo() {
        Assert.assertFalse(Main.kiemTraSoNguyenTo(0));
    }
}
