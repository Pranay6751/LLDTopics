public class FacadePatternDemo {

    // -------------------- Subsystem Classes --------------------

    static class InventoryService {
        public void reserveProduct() {
            System.out.println("Inventory: Product Reserved");
        }
    }

    static class PaymentService {
        public void makePayment() {
            System.out.println("Payment: Successful");
        }
    }

    static class InvoiceService {
        public void generateInvoice() {
            System.out.println("Invoice: Generated");
        }
    }

    static class ShippingService {
        public void shipProduct() {
            System.out.println("Shipping: Product Shipped");
        }
    }

    static class NotificationService {
        public void sendEmail() {
            System.out.println("Notification: Email Sent");
        }
    }

    // -------------------- Facade --------------------

    static class CheckoutFacade {

        private InventoryService inventory = new InventoryService();
        private PaymentService payment = new PaymentService();
        private InvoiceService invoice = new InvoiceService();
        private ShippingService shipping = new ShippingService();
        private NotificationService notification = new NotificationService();

        public void placeOrder() {

            inventory.reserveProduct();
            payment.makePayment();
            invoice.generateInvoice();
            shipping.shipProduct();
            notification.sendEmail();

            System.out.println("\nOrder Placed Successfully!");
        }
    }

    // -------------------- Client --------------------

    public static void main(String[] args) {

        CheckoutFacade checkout = new CheckoutFacade();

        checkout.placeOrder();
    }
}
