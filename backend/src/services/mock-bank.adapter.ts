import { Injectable } from '@nestjs/common';
import { BankAdapter } from './bank-adapter.interface';
import { v4 as uuidv4 } from 'uuid';

@Injectable()
export class MockBankAdapter implements BankAdapter {
  async createAuthSession(userId: string) {
    const sessionId = uuidv4();
    const authUrl = `http://localhost:3000/mock-bank/auth?session=${sessionId}`;
    return { authUrl, sessionId };
  }
  async handleCallback(sessionId: string, params: any){
    return;
  }
  async fetchAccounts(connectionRecord: any){
    return [{ accountId: 'acc-1', iban: 'PL61109010140000071219812874', currency: 'PLN', name: 'Rachunek bieżący' }];
  }
  async fetchTransactions(connectionRecord: any, accountId: string, from?: string, to?: string){
    return [
      { txId: 'tx1', amount: -50.0, currency: 'PLN', description: 'Biedronka', bookingDate: '2025-10-01' },
      { txId: 'tx2', amount: -120.5, currency: 'PLN', description: 'BP Stacja', bookingDate: '2025-10-03' }
    ];
  }
  async refreshToken(connectionRecord: any){
    return;
  }
}
