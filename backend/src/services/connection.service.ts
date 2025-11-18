import { Injectable } from '@nestjs/common';
import { MockBankAdapter } from './mock-bank.adapter';

@Injectable()
export class ConnectionService {
  private sessions = new Map<string, any>();

  constructor(private readonly mockAdapter: MockBankAdapter){}

  async startAuth(provider: string, userId: string){
    const session = await this.mockAdapter.createAuthSession(userId);
    this.sessions.set(session.sessionId, { userId, provider, status: 'pending' });
    return session;
  }

  async getStatus(sessionId: string){
    const s = this.sessions.get(sessionId);
    if (!s) return { status: 'not_found' };
    return { status: s.status };
  }
}
