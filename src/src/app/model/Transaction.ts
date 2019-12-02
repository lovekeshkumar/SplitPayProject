export class Transaction {
    tid: number 
    amount: number
    bfk: number
    ffk: number
    purpose: string

    constructor(){
        this.tid = 0
        this.amount = 0
        this.bfk = 0
        this.ffk = 0
        this.purpose = ''
    }
}