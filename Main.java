public class Main {
    public static void main(String[] args)
            throws CustomerNotExistException, QuantityException {
        System.out.println("Магазин Онлаин");
        Service.getCustomerList().add(new Customer("Иванова Софья",
                LocalDate.of(1990, 1, 1),
                "7018887766", Gender.male));
        Service.getCustomerList().add(new Customer("Потапова Елизавета",
                LocalDate.of(1991, 8, 5),
                "7058887755", Gender.female));
        Service.getCustomerList().add(new Customer("Петрова Анастасия",
                LocalDate.of(1989, 5, 7),
                "7088887733", Gender.female));
        Service.getCustomerList().add(new Customer("Стручков Петр",
                LocalDate.of(1988, 6, 12),
                "7068887722", Gender.male));
        Service.getCustomerList().add(new Customer("Сидоров Иван",
                LocalDate.of(1995, 3, 13),
                "7008887711", Gender.male));
              
    public static String congratulations(List<Customer> customers) {
        LocalDate testDate = LocalDate.of(2024, 8, 23);
        List<Customer> customersToCongratulateBirthdate = new ArrayList<>();
        List<Customer> customersToCongratulateNewYear = new ArrayList<>();
        List<Customer> customersToCongratulateDefendersFatherland = new ArrayList<>();
        List<Customer> customersToCongratulateInternationalWomensDay = new ArrayList<>();

        for (Customer customer : customers) {
            if (customer.getDateOfBirth().getMonthValue() == testDate.getMonthValue()
                    && customer.getDateOfBirth().getDayOfMonth() == testDate.getDayOfMonth()) {
                customersToCongratulateBirthdate.add(customer);
            }
            if (testDate.getMonthValue() == Holidays.NEW_YEAR.getMonth()
                    && testDate.getDayOfMonth() == Holidays.NEW_YEAR.getDay()) {
                customersToCongratulateNewYear.add(customer);
            }
            if (testDate.getMonthValue() == Holidays.DEFENDER_FATHERLAND_DAY.getMonth()
                    && testDate.getDayOfMonth() == Holidays.DEFENDER_FATHERLAND_DAY.getDay()
                    && customer.getGender() == Gender.male) {
                customersToCongratulateDefendersFatherland.add(customer);
            }
            if (testDate.getMonthValue() == Holidays.INTERNATIONAL_WOMENS_DAY.getMonth()
                    && testDate.getDayOfMonth() == Holidays.INTERNATIONAL_WOMENS_DAY.getDay()
                    && customer.getGender() == Gender.female) {
                customersToCongratulateInternationalWomensDay.add(customer);
            }

        }
        if (!customersToCongratulateBirthdate.isEmpty()) {
            coungratulateToHoliday(customersToCongratulateBirthdate, " с днем рождения!");
        }

        if (!customersToCongratulateNewYear.isEmpty()) {
            coungratulateToHoliday(customersToCongratulateNewYear, " с наступающим Новым годом!");
        } else if (!customersToCongratulateDefendersFatherland.isEmpty()) {
            coungratulateToHoliday(customersToCongratulateDefendersFatherland, " с Днем защитника Отечества!");
        } else if (!customersToCongratulateInternationalWomensDay.isEmpty()) {
            coungratulateToHoliday(customersToCongratulateInternationalWomensDay, " с Международным женским днем!");
        } else {
            return "Сегодня рабочий (не праздничный день)";
        }
        return "";
    }

    public static void coungratulateToHoliday(List<Customer> customers, String message) {
        for (Customer customer : customers) {
            System.out.println(STR."Поздравляем \{customer.getName()}\{message}");
        }
    }
}
