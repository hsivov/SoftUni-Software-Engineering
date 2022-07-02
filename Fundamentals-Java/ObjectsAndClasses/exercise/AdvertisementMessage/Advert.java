package ObjectsAndClasses.exercise.AdvertisementMessage;

public class Advert {
        String laudatoryPhrase;
        String event;
        String author;
        String city;

        public void setLaudatoryPhrase(String laudatoryPhrase) {
            this.laudatoryPhrase = laudatoryPhrase;
        }

        public String getLaudatoryPhrase() {
            return laudatoryPhrase;
        }

        public void setEvent(String event) {
            this.event = event;
        }

        public String getEvent() {
            return event;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getAuthor() {
            return author;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCity() {
            return city;
        }

        @Override
        public String toString () {
            return String.format("%s %s %s – %s.", this.laudatoryPhrase, this.event, this.author, this.city);
        }
}
