
export class Item {
    private amount: number
    private inventory_code: number
    private item_no: number
    private name: string

    constructor(data: { amount: number, inventory_code: number, item_no: number, name: string }) {
        this.amount = data.amount;
        this.inventory_code = data.inventory_code;
        this.item_no = data.item_no;
        this.name = data.name;
    }

    set(data: { amount: number, inventory_code: number, item_no: number, name: string }) {
        this.amount = data.amount;
        this.inventory_code = data.inventory_code;
        this.item_no = data.item_no;
        this.name = data.name;
    }


}