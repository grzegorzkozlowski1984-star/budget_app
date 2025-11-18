import { Controller, Get, Query } from '@nestjs/common';
import { MockBankAdapter } from '../services/mock-bank.adapter';

@Controller('accounts')
export class AccountsController {
  constructor(private readonly adapter: MockBankAdapter){}

  @Get()
  async getAccounts(){
    return this.adapter.fetchAccounts({});
  }

  @Get('transactions')
  async getTransactions(@Query('accountId') accountId: string){
    return this.adapter.fetchTransactions({}, accountId);
  }
}
