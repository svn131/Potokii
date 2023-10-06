package Patterns;

public class BuilderPattern {
    public static void main(String[] args) {
        Person person = new Person.Builder()
                .setFirstName("John")
                .setLastName("Doe")
                .setAge(30)
                .setAddress("123 Main St")
                .build();
    }

     static class  Person {
        private final String firstName;
        private final String lastName;
        private final int age;
        private final String address;

        private Person(Builder builder) {
            this.firstName = builder.firstName;
            this.lastName = builder.lastName;
            this.age = builder.age;
            this.address = builder.address;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public int getAge() {
            return age;
        }

        public String getAddress() {
            return address;
        }

        public static class Builder {
            private String firstName;
            private String lastName;
            private int age;
            private String address;

            public Builder() {
                // По умолчанию не требуется обязательных полей
            }

            public Builder setFirstName(String firstName) {
                this.firstName = firstName;
                return this;
            }

            public Builder setLastName(String lastName) {
                this.lastName = lastName;
                return this;
            }

            public Builder setAge(int age) {
                this.age = age;
                return this;
            }

            public Builder setAddress(String address) {
                this.address = address;
                return this;
            }

            public Person build() {
                return new Person(this);
            }
        }


    }
}