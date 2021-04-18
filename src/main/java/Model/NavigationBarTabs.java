package Model;


import org.openqa.selenium.By;

public enum NavigationBarTabs {

        PROJECTS(".//span[@class='title' and text()='Проекты']"),
    COUNTER_PARTIES(".//span[@class='title' and text()='Контрагенты']");

        private final By by;
        NavigationBarTabs(String xpath) {
            this.by = By.xpath(xpath);
        }

        public By getBy() {
            return by;
        }
    }


