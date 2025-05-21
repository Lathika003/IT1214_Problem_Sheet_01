class Vehicle {
    private String licensePlate;
    private String ownerName;
    private int hoursParked;

    public Vehicle(String licensePlate, String ownerName, int hoursParked) {
        this.licensePlate = licensePlate;
        this.ownerName = ownerName;
        this.hoursParked = hoursParked;
    }

    public String getLicensePlate() { return licensePlate; }
    public String getOwnerName() { return ownerName; }
    public int getHoursParked() { return hoursParked; }
}

class ParkingLot {
    private Vehicle[] vehicles = new Vehicle[5]; 
    private int vehicleCount = 0;

    public void parkVehicle(Vehicle vehicle) {
        if (vehicleCount < vehicles.length) {
            vehicles[vehicleCount++] = vehicle;
        } else {
            System.out.println("Parking lot is full, cannot park more vehicles.");
        }
    }

    public void removeVehicle(String licensePlate) {
        int index = -1;
        for (int i = 0; i < vehicleCount; i++) {
            if (vehicles[i].getLicensePlate().equals(licensePlate)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Vehicle with license plate " + licensePlate + " not found.");
            return;
        }

        
        for (int i = index; i < vehicleCount - 1; i++) {
            vehicles[i] = vehicles[i + 1];
        }
        vehicles[--vehicleCount] = null; 
    }

    public void displayVehicles() {
        System.out.println("License Plate  Owner Name  Hours Parked");
        for (int i = 0; i < vehicleCount; i++) {
System.out.println(vehicles[i].getLicensePlate() + "\t" + vehicles[i].getOwnerName() + "\t" + vehicles[i].getHoursParked());        }
    }
}

 class ParkingSystem {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot();

        
        parkingLot.parkVehicle(new Vehicle("ABC123", "John Doe", 2));
        parkingLot.parkVehicle(new Vehicle("XYZ789", "Jane Smith", 4));
        parkingLot.parkVehicle(new Vehicle("LMN456", "Bob Brown", 1));

        
        parkingLot.removeVehicle("XYZ789");

        
        parkingLot.displayVehicles();
    }
}